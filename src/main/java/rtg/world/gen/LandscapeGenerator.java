
package rtg.world.gen;

import java.util.Arrays;

import net.minecraft.world.biome.BiomeGenBase;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.util.PlaneLocation;
import rtg.util.TimeTracker;
import rtg.util.TimedHashMap;
import rtg.world.biome.BiomeAnalyzer;
import rtg.world.biome.RTGBiomeProvider;
import rtg.world.biome.realistic.RealisticBiomeBase;

/**
 *
 * @author Zeno410
 */
public class LandscapeGenerator {

    private final int sampleSize = 8;
    private final int sampleArraySize;
    private final int[] biomeData;
    private int[][] sparseIndices; // [256][varies] — per-column sparse map sample indices
    private float[][] sparseWeights; // [256][varies] — per-column sparse weights
    private final OpenSimplexNoise simplex;
    private final CellNoise cell;
    private final float[] weightedBiomes = new float[BiomeGenBase.getBiomeGenArray().length];
    private final int[] activeBiomeIds = new int[BiomeGenBase.getBiomeGenArray().length];
    private final BiomeAnalyzer analyzer = new BiomeAnalyzer();
    private final TimedHashMap<PlaneLocation, ChunkLandscape> storage = new TimedHashMap<PlaneLocation, ChunkLandscape>(
        60 * 1000);

    public LandscapeGenerator(OpenSimplexNoise simplex, CellNoise cell) {
        sampleArraySize = sampleSize * 2 + 5;
        biomeData = new int[sampleArraySize * sampleArraySize];
        this.simplex = simplex;
        this.cell = cell;
        setWeightings();
    }

    public static String biomeLayoutActivity = "Biome Layout";
    private static final String rtgTerrain = "RTG Terrain";
    private static final String rtgNoise = "RTG Noise";

    private void setWeightings() {
        int totalMapPoints = sampleArraySize * sampleArraySize;
        float limit = (float) Math.pow((56f * 56f), .7);

        sparseIndices = new int[256][];
        sparseWeights = new float[256][];
        int[] tmpIndices = new int[totalMapPoints];
        float[] tmpWeights = new float[totalMapPoints];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int col = i * 16 + j;
                int count = 0;

                for (int mapX = 0; mapX < sampleArraySize; mapX++) {
                    for (int mapZ = 0; mapZ < sampleArraySize; mapZ++) {
                        float xDist = (i - chunkCoordinate(mapX));
                        float yDist = (j - chunkCoordinate(mapZ));
                        float distanceSquared = xDist * xDist + yDist * yDist;
                        float distance = (float) Math.pow(distanceSquared, .7);
                        float weight = 1f - distance / limit;
                        if (weight > 0) {
                            tmpIndices[count] = mapX * sampleArraySize + mapZ;
                            tmpWeights[count] = weight;
                            count++;
                        }
                    }
                }

                sparseIndices[col] = Arrays.copyOf(tmpIndices, count);
                sparseWeights[col] = Arrays.copyOf(tmpWeights, count);
            }
        }
    }

    private int chunkCoordinate(int biomeMapCoordinate) {
        return (biomeMapCoordinate - sampleSize) * 8;
    }

    public int getBiomeDataAt(RTGBiomeProvider cmr, int worldX, int worldY) {
        int chunkX = worldX & 15;
        int chunkY = worldY & 15;
        ChunkLandscape target = this.landscape(cmr, worldX - chunkX, worldY - chunkY);
        return target.biome[chunkX * 16 + chunkY].baseBiome.biomeID;
    }

    public synchronized ChunkLandscape landscape(RTGBiomeProvider cmr, int worldX, int worldY) {
        PlaneLocation location = new PlaneLocation.Invariant(worldX, worldY);
        ChunkLandscape preExisting = this.storage.get(location);
        if (preExisting != null) return preExisting;
        ChunkLandscape result = new ChunkLandscape();
        getNewerNoise(cmr, worldX, worldY, result);
        int[] biomeIndices = cmr.getBiomesGens(worldX, worldY, 16, 16);
        // -cmr.getRiverStrength(cx * 16 + 7, cy * 16 + 7));
        analyzer.newRepair(biomeIndices, result.biome, this.biomeData, this.sampleSize, result.noise, result.river);
        storage.put(location, result);
        return result;
    }

    @SuppressWarnings("unused") // EID compatability injection target
    private void getNewerNoise(RTGBiomeProvider cmr, int x, int y, ChunkLandscape landscape) {
        int eidBiomeIdCount = 256;
        // get area biome map
        TimeTracker.manager.start(rtgNoise);
        TimeTracker.manager.start(biomeLayoutActivity);
        for (int i = -sampleSize; i < sampleSize + 5; i++) {
            for (int j = -sampleSize; j < sampleSize + 5; j++) {
                biomeData[(i + sampleSize) * sampleArraySize
                    + (j + sampleSize)] = cmr.getBiomeDataAt(x + ((i * 8)), y + ((j * 8))).baseBiome.biomeID;
            }
        }

        TimeTracker.manager.stop(biomeLayoutActivity);
        float river;

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int col = i * 16 + j;
                TimeTracker.manager.start("Weighting");

                // Sparse weight accumulation with active biome tracking
                float totalWeight = 0;
                int activeBiomeCount = 0;
                int[] indices = sparseIndices[col];
                float[] weights = sparseWeights[col];
                for (int s = 0; s < indices.length; s++) {
                    int biomeId = biomeData[indices[s]];
                    if (weightedBiomes[biomeId] == 0f) {
                        activeBiomeIds[activeBiomeCount++] = biomeId;
                    }
                    totalWeight += weights[s];
                    weightedBiomes[biomeId] += weights[s];
                }

                Arrays.sort(activeBiomeIds, 0, activeBiomeCount);

                for (int a = 0; a < activeBiomeCount; a++) {
                    weightedBiomes[activeBiomeIds[a]] /= totalWeight;
                }

                landscape.noise[col] = 0f;

                TimeTracker.manager.stop("Weighting");
                TimeTracker.manager.start("Generating");
                river = cmr.getRiverStrength(x + i, y + j);
                landscape.river[col] = -river;
                float totalBorder = 0f;

                for (int a = 0; a < activeBiomeCount; a++) {
                    int k = activeBiomeIds[a];
                    totalBorder += weightedBiomes[k];
                    float rNoiseResult = RealisticBiomeBase.getBiome(k)
                        .rNoise(simplex, cell, x + i, y + j, weightedBiomes[k], river + 1f);
                    landscape.noise[col] += rNoiseResult * weightedBiomes[k];
                    weightedBiomes[k] = 0f;
                }
                if (totalBorder < .999 || totalBorder > 1.001) throw new RuntimeException("" + totalBorder);
                TimeTracker.manager.stop("Generating");
            }
        }

        // fill biomes array with biomeData

        TimeTracker.manager.start(biomeLayoutActivity);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                landscape.biome[i * 16 + j] = cmr.getBiomeDataAt(x + (((i - 7) * 8 + 4)), y + (((j - 7) * 8 + 4)));
            }
        }

        TimeTracker.manager.stop(biomeLayoutActivity);
        TimeTracker.manager.stop(rtgNoise);
    }

}

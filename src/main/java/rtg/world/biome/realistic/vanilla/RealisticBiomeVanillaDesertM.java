package rtg.world.biome.realistic.vanilla;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.biome.deco.collection.DecoCollectionDesert;
import rtg.world.biome.deco.collection.DecoCollectionDesertRiver;
import rtg.world.gen.surface.vanilla.SurfaceVanillaDesertM;
import rtg.world.gen.terrain.vanilla.TerrainVanillaDesertM;

public class RealisticBiomeVanillaDesertM extends RealisticBiomeVanillaBase {

    public static BiomeGenBase standardBiome = BiomeGenBase.desert;
    public static BiomeGenBase mutationBiome = BiomeGenBase.getBiome(standardBiome.biomeID + MUTATION_ADDEND);

    public static Block topBlock = mutationBiome.topBlock;
    public static Block fillerBlock = mutationBiome.fillerBlock;

    public RealisticBiomeVanillaDesertM(BiomeConfig config) {

        super(
            config,
            mutationBiome,
            BiomeGenBase.river,
            new TerrainVanillaDesertM(10f, 20f, 68f, 200f),
            new SurfaceVanillaDesertM(config, Blocks.sand, Blocks.sandstone, false, null, 0.95f));

        this.waterSurfaceLakeChance = 0;
        this.noLakes = true;

        this.addDecoCollection(new DecoCollectionDesertRiver());
        this.addDecoCollection(new DecoCollectionDesert());
    }

    @Override
    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
        Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {
        this.rReplaceRiverSurface(blocks, metadata, i, j, x, y, depth, world, rand, simplex, cell, noise, river, base);
    }
}

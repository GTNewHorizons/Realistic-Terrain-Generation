package rtg.world.gen.surface.highlands;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;

public class SurfaceHLOasis extends SurfaceBase {

    private Block mixBlockTop = Blocks.grass;
    private byte mixBlockTopMeta = 0;
    private float width = 30;
    private float height = .5f;
    private float smallW = 5;
    private float smallS = 1;

    public SurfaceHLOasis(BiomeConfig config, Block top, Block filler) {
        super(config, top, (byte) 0, filler, (byte) 0);
    }

    @Override
    public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
        Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {
        float c = CliffCalculator.calc(x, y, noise);
        boolean cliff = c > 1.4f ? true : false;

        for (int k = 255; k > -1; k--) {
            Block b = blocks[(y * 16 + x) * 256 + k];
            if (b == Blocks.air) {
                depth = -1;
            } else if (b == Blocks.stone) {
                depth++;

                if (cliff) {
                    if (depth > -1 && depth < 2) {
                        if (rand.nextInt(3) == 0) {

                            blocks[(y * 16 + x) * 256 + k] = hcCobble(world, i, j, x, y, k);
                            metadata[(y * 16 + x) * 256 + k] = hcCobbleMeta(world, i, j, x, y, k);
                        } else {

                            blocks[(y * 16 + x) * 256 + k] = hcStone(world, i, j, x, y, k);
                            metadata[(y * 16 + x) * 256 + k] = hcStoneMeta(world, i, j, x, y, k);
                        }
                    } else if (depth < 10) {
                        blocks[(y * 16 + x) * 256 + k] = hcStone(world, i, j, x, y, k);
                        metadata[(y * 16 + x) * 256 + k] = hcStoneMeta(world, i, j, x, y, k);
                    }
                } else {
                    if (depth == 0 && k > 61) {
                        if (c < 0.8
                            && simplex.noise2(i / width, j / width) + simplex.noise2(i / smallW, j / smallW) * smallS
                                > height) {
                            blocks[(y * 16 + x) * 256 + k] = mixBlockTop;
                            metadata[(y * 16 + x) * 256 + k] = mixBlockTopMeta;
                        } else {
                            blocks[(y * 16 + x) * 256 + k] = topBlock;
                            metadata[(y * 16 + x) * 256 + k] = topBlockMeta;
                        }
                    } else if (depth < 4) {

                        if (depth == 1 && c < 0.8 && rand.nextInt(50) == 0) {
                            // put in occasional subsurface water blocks
                            blocks[(y * 16 + x) * 256 + k] = Blocks.water;
                        } else {
                            blocks[(y * 16 + x) * 256 + k] = fillerBlock;
                            metadata[(y * 16 + x) * 256 + k] = fillerBlockMeta;
                        }
                    }
                }
            }
        }
    }
}

package rtg.world.gen.surface;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;

public class SurfaceGrasslandMix1 extends SurfaceBase {

    private Block mixBlock;
    private Block cliffBlock1;
    private Block cliffBlock2;
    private float width;
    private float height;

    public SurfaceGrasslandMix1(BiomeConfig config, Block top, Block filler, Block mix, Block cliff1, Block cliff2,
        float mixWidth, float mixHeight) {
        super(config, top, (byte) 0, filler, (byte) 0);

        mixBlock = mix;
        cliffBlock1 = cliff1;
        cliffBlock2 = cliff2;

        width = mixWidth;
        height = mixHeight;
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
                        blocks[(y * 16 + x) * 256 + k] = rand.nextInt(3) == 0 ? cliffBlock2 : cliffBlock1;
                    } else if (depth < 10) {
                        blocks[(y * 16 + x) * 256 + k] = cliffBlock1;
                    }
                } else {
                    if (depth == 0 && k > 61) {
                        if (simplex.noise2(i / width, j / width) > height) // > 0.27f, i / 12f
                        {
                            blocks[(y * 16 + x) * 256 + k] = mixBlock;
                        } else {
                            blocks[(y * 16 + x) * 256 + k] = topBlock;
                            metadata[(y * 16 + x) * 256 + k] = topBlockMeta;
                        }
                    } else if (depth < 4) {
                        blocks[(y * 16 + x) * 256 + k] = fillerBlock;
                        metadata[(y * 16 + x) * 256 + k] = fillerBlockMeta;
                    }
                }
            }
        }
    }
}

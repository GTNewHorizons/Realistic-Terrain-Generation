package rtg.world.gen.surface.biomesoplenty;

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

public class SurfaceBOPGlacier extends SurfaceBase {

    private Block mixBlockTop;
    private Block mixBlockFill;
    private Block cliffBlock1;
    private Block cliffBlock2;
    private float width;
    private float height;
    private float smallW;
    private float smallS;

    public SurfaceBOPGlacier(BiomeConfig config, Block top, Block filler, Block mixTop, Block mixFill, Block cliff1,
        Block cliff2, float mixWidth, float mixHeight, float smallWidth, float smallStrength) {
        super(config, top, (byte) 0, filler, (byte) 0);

        mixBlockTop = mixTop;
        mixBlockFill = mixFill;
        cliffBlock1 = cliff1;
        cliffBlock2 = cliff2;

        width = mixWidth;
        height = mixHeight;
        smallW = smallWidth;
        smallS = smallStrength;
    }

    @Override
    public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
        Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {
        float c = CliffCalculator.calc(x, y, noise);
        boolean cliff = c > 1.4f ? true : false;
        boolean mix = false;

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
                        if (simplex.noise2(i / width, j / width) + simplex.noise2(i / smallW, j / smallW) * smallS
                            > height) {
                            blocks[(y * 16 + x) * 256 + k] = mixBlockTop;
                            mix = true;
                        } else {
                            blocks[(y * 16 + x) * 256 + k] = topBlock;
                            metadata[(y * 16 + x) * 256 + k] = topBlockMeta;
                        }
                    } else if (depth < 4) {
                        if (mix) {
                            blocks[(y * 16 + x) * 256 + k] = mixBlockFill;
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

package rtg.world.gen.surface.vanilla;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;

public class SurfaceVanillaRiver extends SurfaceBase {

    public SurfaceVanillaRiver(BiomeConfig config) {
        super(config, Blocks.grass, (byte) 0, Blocks.dirt, (byte) 0);
    }

    @Override
    public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world,
        Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base) {
        if (river > 0.05f && river + (simplex.noise2(i / 10f, j / 10f) * 0.15f) > 0.8f) {
            Block b;
            for (int k = 255; k > -1; k--) {
                b = blocks[(y * 16 + x) * 256 + k];
                if (b == Blocks.air) {
                    depth = -1;
                } else if (b != Blocks.water && b != Blocks.obsidian) {
                    depth++;

                    if (depth == 0 && k > 61) {
                        blocks[(y * 16 + x) * 256 + k] = Blocks.grass;
                    } else if (depth < 4) {
                        blocks[(y * 16 + x) * 256 + k] = Blocks.dirt;
                    } else if (depth > 4) {
                        return;
                    }
                }
            }
        }
    }
}

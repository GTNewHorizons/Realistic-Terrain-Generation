package rtg.world.gen.surface.enhancedbiomes;

import net.minecraft.block.Block;

import enhancedbiomes.EnhancedBiomesMod;
import rtg.api.biome.BiomeConfig;
import rtg.world.gen.surface.SurfaceBase;

public class SurfaceEBBase extends SurfaceBase {

    public SurfaceEBBase(BiomeConfig config, Block top, byte topByte, Block fill, byte fillByte) {
        super(config, top, topByte, fill, fillByte);
    }

    public boolean shouldReplaceStone() {

        return (EnhancedBiomesMod.useNewStone == 1) ? true : false;
    }
}

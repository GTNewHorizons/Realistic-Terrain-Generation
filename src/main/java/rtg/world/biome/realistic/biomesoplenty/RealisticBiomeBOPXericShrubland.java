package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPXericShrubland;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPXericShrubland;

public class RealisticBiomeBOPXericShrubland extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.xericShrubland;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPXericShrubland(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.river,
            new TerrainBOPXericShrubland(),
            new SurfaceBOPXericShrubland(
                config,
                topBlock, // Block top
                (byte) 0, // byte topByte
                fillerBlock, // Block filler,
                (byte) 0, // byte fillerByte
                topBlock, // Block mixTop,
                (byte) 0, // byte mixTopByte,
                fillerBlock, // Block mixFill,
                (byte) 0, // byte mixFillByte,
                80f, // float mixWidth,
                -0.15f, // float mixHeight,
                10f, // float smallWidth,
                0.5f // float smallStrength
            ));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

package rtg.world.biome.realistic.enhancedbiomes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import enhancedbiomes.api.EBAPI;
import enhancedbiomes.blocks.EnhancedBiomesBlocks;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.enhancedbiomes.SurfaceEBXericShrubland;
import rtg.world.gen.terrain.enhancedbiomes.TerrainEBXericShrubland;

public class RealisticBiomeEBXericShrubland extends RealisticBiomeEBBase {

    public static Block[] ebDominantStoneBlock = new Block[] {
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone),
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone) };

    public static byte[] ebDominantStoneMeta = new byte[] { EBAPI.ebStonify(EBAPI.MARBLE, (byte) 0),
        EBAPI.ebStonify(EBAPI.HARDENED_SANDSTONE, (byte) 0) };

    public static Block[] ebDominantCobblestoneBlock = new Block[] {
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone),
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone) };

    public static byte[] ebDominantCobblestoneMeta = new byte[] { EBAPI.ebStonify(EBAPI.MARBLE, (byte) 0),
        EBAPI.ebStonify(EBAPI.HARDENED_SANDSTONE, (byte) 0) };

    private static Block ebTopBlock = Blocks.sand;
    private static byte ebTopByte = (byte) 0;
    private static Block ebFillBlock = EBAPI.ebGrassify(EnhancedBiomesBlocks.dirtEB, Blocks.dirt);
    private static byte ebFillByte = EBAPI.ebGrassify(EBAPI.OXISOL, (byte) 0);
    private static Block ebMixTopBlock = EBAPI.ebGrassify(EnhancedBiomesBlocks.grassEB, Blocks.grass);
    private static byte ebMixTopByte = EBAPI.ebGrassify(EBAPI.OXISOL, (byte) 0);
    private static Block ebMixFillBlock = EBAPI.ebGrassify(EnhancedBiomesBlocks.dirtEB, Blocks.dirt);
    private static byte ebMixFillByte = EBAPI.ebGrassify(EBAPI.OXISOL, (byte) 0);
    private static Block ebCliff1Block = EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone);
    private static byte ebCliff1Byte = EBAPI.ebStonify(EBAPI.HARDENED_SANDSTONE, (byte) 0);
    private static Block ebCliff2Block = EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone);
    private static byte ebCliff2Byte = EBAPI.ebStonify(EBAPI.HARDENED_SANDSTONE, (byte) 0);

    public RealisticBiomeEBXericShrubland(BiomeGenBase ebBiome, BiomeConfig config) {
        super(
            config,
            ebBiome,
            BiomeGenBase.river,
            new TerrainEBXericShrubland(),
            new SurfaceEBXericShrubland(
                config,
                ebTopBlock, // Block top
                ebTopByte, // byte topByte
                ebFillBlock, // Block filler,
                ebFillByte, // byte fillerByte
                ebMixTopBlock, // Block mixTop,
                ebMixTopByte, // byte mixTopByte,
                ebMixFillBlock, // Block mixFill,
                ebMixFillByte, // byte mixFillByte,
                ebCliff1Block, // Block cliff1,
                ebCliff1Byte, // byte cliff1Byte,
                ebCliff2Block, // Block cliff2,
                ebCliff2Byte, // byte cliff2Byte,
                80f, // float mixWidth,
                -0.15f, // float mixHeight,
                10f, // float smallWidth,
                0.5f // float smallStrength
            ));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

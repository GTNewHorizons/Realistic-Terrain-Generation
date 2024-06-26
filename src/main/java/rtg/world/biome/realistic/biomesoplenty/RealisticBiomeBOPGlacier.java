package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPGlacier;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPGlacier;

public class RealisticBiomeBOPGlacier extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.glacier;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPGlacier(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.frozenRiver,
            new TerrainBOPGlacier(230f, 40f, 68f),
            new SurfaceBOPGlacier(
                config,
                topBlock,
                fillerBlock,
                topBlock,
                fillerBlock,
                Blocks.packed_ice,
                Blocks.ice,
                60f,
                -0.14f,
                14f,
                0.25f));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

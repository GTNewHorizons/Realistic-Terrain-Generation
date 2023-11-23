package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPThicket;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPThicket;

public class RealisticBiomeBOPThicket extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.thicket;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPThicket(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.river,
            new TerrainBOPThicket(),
            new SurfaceBOPThicket(config, topBlock, fillerBlock));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPShrubland;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPShrubland;

public class RealisticBiomeBOPShrubland extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.shrubland;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPShrubland(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.river,
            new TerrainBOPShrubland(),
            new SurfaceBOPShrubland(config, topBlock, fillerBlock));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPHighland;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPHighland;

public class RealisticBiomeBOPHighland extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.highland;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPHighland(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.river,
            new TerrainBOPHighland(),
            new SurfaceBOPHighland(config, topBlock, fillerBlock));
        this.generatesEmeralds = true;
        noWaterFeatures = true;

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

package rtg.world.biome.realistic.highlands;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import highlands.api.HighlandsBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.highlands.SurfaceHLCliffs;
import rtg.world.gen.terrain.highlands.TerrainHLCliffs;

public class RealisticBiomeHLCliffs extends RealisticBiomeHLBase {

    public static BiomeGenBase hlBiome = HighlandsBiomes.cliffs;

    public static Block topBlock = hlBiome.topBlock;
    public static Block fillerBlock = hlBiome.fillerBlock;

    public RealisticBiomeHLCliffs(BiomeConfig config) {

        super(
            config,
            hlBiome,
            BiomeGenBase.river,
            new TerrainHLCliffs(75f, 70f, 78f),
            new SurfaceHLCliffs(config, topBlock, fillerBlock, false, null, 0.95f));
        this.generatesEmeralds = true;
        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

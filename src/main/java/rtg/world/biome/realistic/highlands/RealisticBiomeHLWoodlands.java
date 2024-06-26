package rtg.world.biome.realistic.highlands;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import highlands.api.HighlandsBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.highlands.SurfaceHLWoodlands;
import rtg.world.gen.terrain.highlands.TerrainHLWoodlands;

public class RealisticBiomeHLWoodlands extends RealisticBiomeHLBase {

    public static BiomeGenBase hlBiome = HighlandsBiomes.woodlands;

    public static Block topBlock = hlBiome.topBlock;
    public static Block fillerBlock = hlBiome.fillerBlock;

    public RealisticBiomeHLWoodlands(BiomeConfig config) {

        super(
            config,
            hlBiome,
            BiomeGenBase.river,
            new TerrainHLWoodlands(230f, 15f, 0f),
            new SurfaceHLWoodlands(config, topBlock, fillerBlock, false, null, 0.95f));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

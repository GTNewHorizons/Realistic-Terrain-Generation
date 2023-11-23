package rtg.world.biome.realistic.highlands;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import highlands.api.HighlandsBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.highlands.SurfaceHLJungleIsland;
import rtg.world.gen.terrain.highlands.TerrainHLJungleIsland;

public class RealisticBiomeHLJungleIsland extends RealisticBiomeHLBase {

    public static BiomeGenBase hlBiome = HighlandsBiomes.jungleIsland;

    public static Block topBlock = hlBiome.topBlock;
    public static Block fillerBlock = hlBiome.fillerBlock;

    public RealisticBiomeHLJungleIsland(BiomeConfig config) {

        super(
            config,
            hlBiome,
            BiomeGenBase.river,
            new TerrainHLJungleIsland(0f, 40f, 68f, 200f),
            new SurfaceHLJungleIsland(config, topBlock, fillerBlock));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
        noLakes = true;
        noWaterFeatures = true;
    }
}

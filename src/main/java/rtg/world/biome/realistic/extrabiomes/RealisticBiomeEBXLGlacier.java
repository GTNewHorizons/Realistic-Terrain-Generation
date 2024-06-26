package rtg.world.biome.realistic.extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import extrabiomes.api.BiomeManager;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.extrabiomes.SurfaceEBXLGlacier;
import rtg.world.gen.terrain.extrabiomes.TerrainEBXLGlacier;

public class RealisticBiomeEBXLGlacier extends RealisticBiomeEBXLBase {

    public static BiomeGenBase ebxlBiome = BiomeManager.glacier.get();

    public static Block topBlock = ebxlBiome.topBlock;
    public static Block fillerBlock = ebxlBiome.fillerBlock;

    public RealisticBiomeEBXLGlacier(BiomeConfig config) {
        super(
            config,
            ebxlBiome,
            BiomeGenBase.frozenRiver,
            new TerrainEBXLGlacier(),
            new SurfaceEBXLGlacier(config, topBlock, fillerBlock, false, null, 0.95f));
        noWaterFeatures = true;

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

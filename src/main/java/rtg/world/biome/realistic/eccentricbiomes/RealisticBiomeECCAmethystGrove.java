package rtg.world.biome.realistic.eccentricbiomes;

import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.eccentricbiomes.SurfaceECCAmethystGrove;
import rtg.world.gen.terrain.eccentricbiomes.TerrainECCAmethystGrove;

public class RealisticBiomeECCAmethystGrove extends RealisticBiomeECCBase {

    public RealisticBiomeECCAmethystGrove(BiomeGenBase eccBiome, BiomeConfig config) {

        super(
            config,
            eccBiome,
            BiomeGenBase.river,
            new TerrainECCAmethystGrove(),
            new SurfaceECCAmethystGrove(config, eccBiome.topBlock, eccBiome.fillerBlock));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}

package rtg.world.biome.realistic.extrabiomes;

import extrabiomes.api.BiomeManager;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.extrabiomes.SurfaceEBXLBirchForest;
import rtg.world.gen.terrain.extrabiomes.TerrainEBXLBirchForest;

public class RealisticBiomeEBXLBirchForest extends RealisticBiomeEBXLBase
{
	public static BiomeGenBase ebxlBiome = BiomeManager.birchforest.get();

	public static Block topBlock = ebxlBiome.topBlock;
	public static Block fillerBlock = ebxlBiome.fillerBlock;

	public RealisticBiomeEBXLBirchForest(BiomeConfig config)
	{
		super(config,
			ebxlBiome, BiomeGenBase.river,
			new TerrainEBXLBirchForest(),
			new SurfaceEBXLBirchForest(config, topBlock, fillerBlock, false, null,3f)
		);

		DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
		this.addDeco(decoBaseBiomeDecorations);
	}
}

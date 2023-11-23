package rtg.world.biome.realistic.biomesoplenty;

import biomesoplenty.api.content.BOPCBiomes;
import biomesoplenty.api.content.BOPCBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPSludgepit;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPSludgepit;

public class RealisticBiomeBOPSludgepit extends RealisticBiomeBOPBase
{
	public static BiomeGenBase bopBiome = BOPCBiomes.sludgepit;

    public static Block topBlock = BOPCBlocks.newBopGrass;
    public static Block fillerBlock = BOPCBlocks.newBopDirt;

	public RealisticBiomeBOPSludgepit(BiomeConfig config)
	{
		super(config,
			bopBiome, BiomeGenBase.river,
			new TerrainBOPSludgepit(),
			new SurfaceBOPSludgepit(config, topBlock, fillerBlock)
		);

		DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
		this.addDeco(decoBaseBiomeDecorations);
	}
}

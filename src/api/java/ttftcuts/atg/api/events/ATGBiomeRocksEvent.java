package ttftcuts.atg.api.events;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.world.biome.BiomeGenBase;

public class ATGBiomeRocksEvent extends Event {

	public BiomeGenBase biome;
	public int rockChance;
	public int bigRockChance;
	public int rocksPerChunk;

	public ATGBiomeRocksEvent( BiomeGenBase biome, int rockChance, int bigRockChance, int rocksPerChunk ) {
		this.biome = biome;
		this.rockChance = rockChance;
		this.bigRockChance = bigRockChance;
		this.rocksPerChunk = rocksPerChunk;
	}
}

package ttftcuts.atg.api.events;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.List;

public class ATGBiomeGroupRequestEvent extends Event {

	public BiomeGenBase biome;
	public List<String> groups;

	public ATGBiomeGroupRequestEvent(BiomeGenBase biome) {
		this.biome = biome;
		this.groups = null;
	}
}

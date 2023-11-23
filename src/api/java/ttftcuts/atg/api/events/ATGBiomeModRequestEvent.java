package ttftcuts.atg.api.events;

import com.google.common.base.Optional;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.world.biome.BiomeGenBase;
import ttftcuts.atg.api.IGenMod;

public class ATGBiomeModRequestEvent extends Event {

	public BiomeGenBase biome;
	public Optional<IGenMod> mod;

	public ATGBiomeModRequestEvent(BiomeGenBase biome) {
		this.biome = biome;
		this.mod = Optional.absent();
	}
}

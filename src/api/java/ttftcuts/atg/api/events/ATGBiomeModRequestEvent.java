package ttftcuts.atg.api.events;

import net.minecraft.world.biome.BiomeGenBase;

import com.google.common.base.Optional;

import cpw.mods.fml.common.eventhandler.Event;
import ttftcuts.atg.api.IGenMod;

public class ATGBiomeModRequestEvent extends Event {

    public BiomeGenBase biome;
    public Optional<IGenMod> mod;

    public ATGBiomeModRequestEvent(BiomeGenBase biome) {
        this.biome = biome;
        this.mod = Optional.absent();
    }
}

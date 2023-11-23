package ttftcuts.atg.api.events;

import net.minecraft.world.biome.BiomeGenBase;

import com.google.common.base.Optional;

import cpw.mods.fml.common.eventhandler.Event;

public class ATGBiomeRequestEvent extends Event {

    public String biomeName;
    public Optional<BiomeGenBase> biome;

    public ATGBiomeRequestEvent(String biomeName) {
        this.biomeName = biomeName;
        this.biome = Optional.absent();
    }
}

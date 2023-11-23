package rtg.config.ridiculousworld;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import rtg.api.biome.ridiculousworld.config.BiomeConfigRW;
import rtg.config.BiomeConfigManager;
import rtg.util.Logger;

public class ConfigRW {

    public static Configuration config;

    public static void init(File configFile) {

        config = new Configuration(configFile);

        try {
            config.load();

            BiomeConfigManager.setBiomeConfigsFromUserConfigs(BiomeConfigRW.getBiomeConfigs(), config);

        } catch (Exception e) {
            Logger.error("RTG has had a problem loading RW configuration.");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}

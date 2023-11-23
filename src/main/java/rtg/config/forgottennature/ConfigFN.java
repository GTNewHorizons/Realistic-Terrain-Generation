package rtg.config.forgottennature;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import rtg.api.biome.forgottennature.config.BiomeConfigFN;
import rtg.config.BiomeConfigManager;
import rtg.util.Logger;

public class ConfigFN {

    public static Configuration config;

    public static void init(File configFile) {

        config = new Configuration(configFile);

        try {
            config.load();

            BiomeConfigManager.setBiomeConfigsFromUserConfigs(BiomeConfigFN.getBiomeConfigs(), config);

        } catch (Exception e) {
            Logger.error("RTG has had a problem loading FN configuration.");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}

package rtg.config.atg;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import rtg.api.biome.atg.config.BiomeConfigATG;
import rtg.config.BiomeConfigManager;
import rtg.util.Logger;

public class ConfigATG {

    public static Configuration config;

    public static void init(File configFile) {
        config = new Configuration(configFile);

        try {
            config.load();

            BiomeConfigManager.setBiomeConfigsFromUserConfigs(BiomeConfigATG.getBiomeConfigs(), config);
        } catch (Exception e) {
            Logger.error("RTG has had a problem loading ATG configuration.");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}

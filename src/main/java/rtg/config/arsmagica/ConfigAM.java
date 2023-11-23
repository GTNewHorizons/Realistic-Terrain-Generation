package rtg.config.arsmagica;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import rtg.api.biome.arsmagica.config.BiomeConfigAM;
import rtg.config.BiomeConfigManager;
import rtg.util.Logger;

public class ConfigAM {

    public static Configuration config;

    public static void init(File configFile) {

        config = new Configuration(configFile);

        try {
            config.load();

            BiomeConfigManager.setBiomeConfigsFromUserConfigs(BiomeConfigAM.getBiomeConfigs(), config);

        } catch (Exception e) {
            Logger.error("RTG has had a problem loading AM configuration.");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}

package rtg.config.chromaticraft;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import rtg.api.biome.chromaticraft.config.BiomeConfigCC;
import rtg.config.BiomeConfigManager;
import rtg.util.Logger;

public class ConfigCC {

    public static Configuration config;

    public static void init(File configFile) {
        config = new Configuration(configFile);

        try {
            config.load();

            BiomeConfigManager.setBiomeConfigsFromUserConfigs(BiomeConfigCC.getBiomeConfigs(), config);
        } catch (Exception e) {
            Logger.error("RTG has had a problem loading ChromatiCraft configuration.");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}

package rtg.api.biome.vanilla.config;

import rtg.api.biome.BiomeConfigProperty;
import rtg.api.biome.BiomeConfigProperty.Type;
import rtg.config.rtg.ConfigRTG;

public class BiomeConfigVanillaJungleEdgeM extends BiomeConfigVanillaBase {

    public static final String decorationLogsId = "decorationLogs";
    public static final String decorationLogsName = "RTG Decoration: Logs";

    public BiomeConfigVanillaJungleEdgeM() {
        super("jungleedgem");

        this.addProperty(new BiomeConfigProperty(decorationLogsId, Type.BOOLEAN, decorationLogsName, "", true));

        this.setPropertyValueById(allowVolcanoesId, true);
        this.setPropertyValueById(volcanoChanceId, (ConfigRTG.volcanoChance * 2));
    }
}

package rtg.api.biome.atg.config;

public class BiomeConfigATGVolcano extends BiomeConfigATGBase {

    public BiomeConfigATGVolcano() {
        super("volcano");

        this.setPropertyValueById(allowVolcanoesId, true);
        this.setPropertyValueById(volcanoChanceId, -1);
    }
}

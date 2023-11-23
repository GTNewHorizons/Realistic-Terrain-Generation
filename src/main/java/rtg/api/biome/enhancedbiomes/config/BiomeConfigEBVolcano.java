package rtg.api.biome.enhancedbiomes.config;

public class BiomeConfigEBVolcano extends BiomeConfigEBBase
{
    public BiomeConfigEBVolcano()
    {
        super("volcano");

        this.setPropertyValueById(allowVolcanoesId, true);
        this.setPropertyValueById(volcanoChanceId, -1);
    }
}

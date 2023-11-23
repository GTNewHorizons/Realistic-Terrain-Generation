package rtg.api.biome.enhancedbiomes.config;

public class BiomeConfigEBVolcanoM extends BiomeConfigEBBase
{
    public BiomeConfigEBVolcanoM()
    {
        super("volcanom");

        this.setPropertyValueById(allowVolcanoesId, true);
        this.setPropertyValueById(volcanoChanceId, -1);
    }
}

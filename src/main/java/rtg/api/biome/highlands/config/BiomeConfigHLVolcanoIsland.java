package rtg.api.biome.highlands.config;

public class BiomeConfigHLVolcanoIsland extends BiomeConfigHLBase
{
    public BiomeConfigHLVolcanoIsland()
    {
        super("volcanoisland");

        this.setPropertyValueById(allowVolcanoesId, true);
        this.setPropertyValueById(volcanoChanceId, -1);
    }
}

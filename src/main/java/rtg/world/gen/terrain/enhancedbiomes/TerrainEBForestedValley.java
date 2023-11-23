package rtg.world.gen.terrain.enhancedbiomes;

import rtg.world.gen.terrain.FunctionalTerrainBase;
import rtg.world.gen.terrain.GroundEffect;

public class TerrainEBForestedValley extends FunctionalTerrainBase {

    public TerrainEBForestedValley() {
        height = new GroundEffect(groundNoiseAmplitudeHills);
    }

}

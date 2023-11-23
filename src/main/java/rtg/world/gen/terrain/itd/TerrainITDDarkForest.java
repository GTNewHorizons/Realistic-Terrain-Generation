package rtg.world.gen.terrain.itd;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainITDDarkForest extends TerrainBase {

    private float baseHeight = 76f;
    private float hillStrength = 30f;

    public TerrainITDDarkForest() {

    }

    public TerrainITDDarkForest(float bh, float hs) {
        baseHeight = bh;
        hillStrength = hs;
    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

        groundNoise = groundNoise(x, y, groundNoiseAmplitudeHills, simplex);

        float m = hills(x, y, hillStrength, simplex, river);

        return baseHeight + groundNoise + m;
    }
}

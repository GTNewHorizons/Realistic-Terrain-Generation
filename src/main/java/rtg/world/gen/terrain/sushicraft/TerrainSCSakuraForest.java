package rtg.world.gen.terrain.sushicraft;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

/**
 * Created by VelocityRa on 15/4/2016.
 */
public class TerrainSCSakuraForest extends TerrainBase {

    private float baseHeight = 76f;
    private float hillStrength = 30f;

    public TerrainSCSakuraForest() {

    }

    public TerrainSCSakuraForest(float bh, float hs) {
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

package rtg.world.gen.terrain.ridiculousworld;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainRWShadowFen extends TerrainBase {

    public TerrainRWShadowFen() {

    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        return terrainMarsh(x, y, simplex, 61.5f);
    }
}

package rtg.world.gen.terrain.vanilla;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainVanillaFrozenRiver extends TerrainBase {

    public TerrainVanillaFrozenRiver() {

    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        return terrainFlatLakes(x, y, simplex, river, 3f, 60f);
    }
}

package rtg.world.gen.terrain.enhancedbiomes;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainEBCypressForest extends TerrainBase {

    public TerrainEBCypressForest() {}

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        return terrainGrasslandFlats(x, y, simplex, river, 100f, 25f, 68f);
    }
}

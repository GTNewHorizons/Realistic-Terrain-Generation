package rtg.world.gen.terrain.vanilla;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainVanillaSavannaM extends TerrainBase {

    public TerrainVanillaSavannaM() {}

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        return terrainGrasslandMountains(x, y, simplex, cell, river, 4f, 90f, 67f);
    }
}

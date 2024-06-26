package rtg.world.gen.terrain.atg;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainATGWoodland extends TerrainBase {

    private float start;
    private float height;
    private float base;
    private float width;

    public TerrainATGWoodland(float hillStart, float landHeight, float baseHeight, float hillWidth) {
        start = hillStart;
        height = landHeight;
        base = baseHeight;
        width = hillWidth;
    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        return terrainHighland(x, y, simplex, cell, river, start, width, height, 0f);
    }
}

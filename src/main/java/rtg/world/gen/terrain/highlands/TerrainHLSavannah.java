package rtg.world.gen.terrain.highlands;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainHLSavannah extends TerrainBase {

    public TerrainHLSavannah() {}

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

        return terrainPlains(x, y, simplex, river, 160f, 10f, 60f, 200f, 66f);
        /*
         * float h = simplex.noise2(x / 100f, y / 100f) * 7;
         * h += simplex.noise2(x / 20f, y / 20f) * 2;
         * float m = simplex.noise2(x / 180f, y / 180f) * 70f * river;
         * m *= m / 40f;
         * float sm = simplex.noise2(x / 30f, y / 30f) * 8f;
         * sm *= m / 20f > 3.75f ? 3.75f : m / 20f;
         * m += sm;
         * return 68f + h + m;(
         */
    }
}

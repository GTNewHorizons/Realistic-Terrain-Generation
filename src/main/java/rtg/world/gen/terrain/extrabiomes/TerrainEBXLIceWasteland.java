package rtg.world.gen.terrain.extrabiomes;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainEBXLIceWasteland extends TerrainBase {

    public TerrainEBXLIceWasteland() {}

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        return terrainPolar(x, y, simplex, river);
    }
}

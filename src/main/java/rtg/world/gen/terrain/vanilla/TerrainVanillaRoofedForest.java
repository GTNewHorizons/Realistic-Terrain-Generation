package rtg.world.gen.terrain.vanilla;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.GroundEffect;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainVanillaRoofedForest extends TerrainBase {

    public TerrainVanillaRoofedForest() {

    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        // return terrainPlains(x, y, simplex, river, 160f, 10f, 60f, 80f, 65f)
        return riverized(65f + groundEffect.added(simplex, cell, x, y), river);
    }

    private GroundEffect groundEffect = new GroundEffect(4f);
}

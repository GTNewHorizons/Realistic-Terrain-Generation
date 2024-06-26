package rtg.world.gen.terrain.vanilla;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainVanillaMesaPlateauM extends TerrainBase {

    private float[] height;
    private int heightLength;
    private float strength;
    private float base;

    /*
     * Example parameters:
     * allowed to generate rivers?
     * riverGen = true
     * canyon jump heights
     * heightArray = new float[]{2.0f, 0.5f, 6.5f, 0.5f, 14.0f, 0.5f, 19.0f, 0.5f}
     * strength of canyon jump heights
     * heightStrength = 35f
     * canyon width (cliff to cliff)
     * canyonWidth = 160f
     * canyon heigth (total heigth)
     * canyonHeight = 60f
     * canyon strength
     * canyonStrength = 40f
     */
    public TerrainVanillaMesaPlateauM(boolean riverGen, float heightStrength, float canyonWidth, float canyonHeight,
        float canyonStrength, float baseHeight) {
        /**
         * Values come in pairs per layer. First is how high to step up.
         * Second is a value between 0 and 1, signifying when to step up.
         */
        height = new float[] { 18.5f, 0.4f };
        strength = 20f;
        heightLength = height.length;
        base = 69f;
    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        river *= 0.5f;
        return terrainPlateau(x, y, simplex, river, height, border, strength, heightLength, 50f, true);
    }
}

package sgcraft.api;

import java.util.LinkedList;

import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces;

import gcewing.sg.FeatureUnderDesertPyramid;

public class SGCraftAPI {

    public void addStargateToDesertTempleComponents(ComponentScatteredFeaturePieces.DesertPyramid desertpyramid,
        LinkedList desertTempleComponents) {
        FeatureUnderDesertPyramid stargate = new FeatureUnderDesertPyramid(desertpyramid);
        desertTempleComponents.add(stargate);
    }
}

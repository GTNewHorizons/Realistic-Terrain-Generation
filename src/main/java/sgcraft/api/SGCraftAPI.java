package sgcraft.api;

import gcewing.sg.FeatureUnderDesertPyramid;
import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces;

import java.util.LinkedList;


public class SGCraftAPI
{
	public void addStargateToDesertTempleComponents(ComponentScatteredFeaturePieces.DesertPyramid desertpyramid, LinkedList desertTempleComponents)
	{
    	FeatureUnderDesertPyramid stargate = new FeatureUnderDesertPyramid(desertpyramid);
    	desertTempleComponents.add(stargate);
	}
}

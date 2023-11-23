package ttftcuts.atg.api;

import net.minecraft.world.World;

import java.util.Random;

public interface IGenMod {
	public int modify( World world, int height, Random random, double rawHeight, int x, int z );

	public double noiseFactor();
}

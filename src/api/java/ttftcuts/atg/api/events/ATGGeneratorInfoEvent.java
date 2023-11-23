package ttftcuts.atg.api.events;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.world.World;

public class ATGGeneratorInfoEvent extends Event {

	public World world;
	public double x;
	public double z;
	public double[] info;

	public ATGGeneratorInfoEvent(World world, double x, double z) {
		this.world = world;
		this.x = x;
		this.z = z;
	}
}

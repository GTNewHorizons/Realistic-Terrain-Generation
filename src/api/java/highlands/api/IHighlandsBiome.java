package highlands.api;

import net.minecraft.entity.EnumCreatureType;

import java.util.List;
public interface IHighlandsBiome {
	public void setSpawnLists(List monster, List creature, List waterCreature);
	public List getSpawnableList(EnumCreatureType par1EnumCreatureType);
}

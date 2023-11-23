package biomesoplenty.api;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;

public class BOPBlockHelper
{
    public static String getUniqueName(Block block)
    {
        return GameData.getBlockRegistry().getNameForObject(block);
    }
}

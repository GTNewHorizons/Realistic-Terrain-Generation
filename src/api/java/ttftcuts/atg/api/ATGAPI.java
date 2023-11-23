package ttftcuts.atg.api;

import net.minecraft.world.World;

import com.google.common.base.Optional;

public class ATGAPI {

    public static boolean WorldIsATG(World world) {
        return world.provider.terrainType.getWorldTypeName() == "ATG";
    }

    public static Optional<Integer> sealevel = Optional.absent();
}

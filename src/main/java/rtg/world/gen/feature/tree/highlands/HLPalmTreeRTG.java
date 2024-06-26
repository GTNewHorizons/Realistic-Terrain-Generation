package rtg.world.gen.feature.tree.highlands;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

import highlands.Highlands;
import highlands.api.HighlandsBlocks;
import highlands.worldgen.WorldGenTreePalm;

public class HLPalmTreeRTG extends WorldGenTreePalm {

    /**
     * Constructor - gets the generator for the correct highlands tree
     * 
     * @param lmd    leaf meta data
     * @param wmd    wood meta data
     * @param wb     wood block
     * @param lb     leaf block
     * @param minH   minimum height of tree trunk
     * @param maxH   max possible height above minH the tree trunk could grow
     * @param notify whether or not to notify blocks of the tree being grown.
     *               Generally false for world generation, true for saplings.
     */
    public HLPalmTreeRTG(int lmd, int wmd, Block wb, Block lb, int minH, int maxH, boolean notify) {
        super(lmd, wmd, wb, lb, minH, maxH, notify);
    }

    public HLPalmTreeRTG(int minH, int maxH, boolean notify) {
        this(0, 0, HighlandsBlocks.palmWood, HighlandsBlocks.palmLeaves, minH, maxH, notify);

        this.wood = Blocks.log;
        this.woodMeta = 3;

        if (Highlands.vanillaBlocksFlag) {
            this.leaves = Blocks.leaves;
            this.leavesMeta = 3;
        }
    }

    @Override
    public boolean generate(World world, Random random, int locX, int locY, int locZ) {
        this.worldObj = world;
        this.random = random;

        if (!isLegalTreePosition(world, locX, locY, locZ) && world.getBlock(locX, locY - 1, locZ) != Blocks.sand) {
            this.worldObj = null;
            return false;
        }
        if (!isCubeClear(locX, locY + 3, locZ, 1, 4)) {
            return false;
        }

        // generates trunk
        int treeHeight = minHeight + random.nextInt(maxHeight);
        for (int i = 0; i < treeHeight; i++) {
            setBlockInWorld(locX, locY + i, locZ, this.wood, this.woodMeta);
        }
        // generates leaves
        int h = locY + treeHeight;
        setBlockInWorld(locX, h, locZ, this.leaves, this.leavesMeta);
        int r = 1;
        setBlockInWorld(locX + r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ - r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX + r, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ - r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX + r, h, locZ - r, this.leaves, this.leavesMeta);
        r++;
        setBlockInWorld(locX + r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ - r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX + r, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ - r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX + r, h, locZ - r, this.leaves, this.leavesMeta);
        r++;
        setBlockInWorld(locX + r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ - r, this.leaves, this.leavesMeta);
        h--;
        setBlockInWorld(locX + r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ - r, this.leaves, this.leavesMeta);
        r++;
        setBlockInWorld(locX + r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX - r, h, locZ, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ + r, this.leaves, this.leavesMeta);
        setBlockInWorld(locX, h, locZ - r, this.leaves, this.leavesMeta);

        if (random.nextInt(3) == 0) {
            for (int k1 = 0; k1 < 4; ++k1) {
                if (random.nextInt(2) == 0) {
                    int i2 = random.nextInt(3);
                    this.setBlockAndNotifyAdequately(
                        world,
                        locX + Direction.offsetX[Direction.rotateOpposite[k1]],
                        h,
                        locZ + Direction.offsetZ[Direction.rotateOpposite[k1]],
                        Blocks.cocoa,
                        i2 << 2 | k1);
                }
            }
        }
        this.worldObj = null;
        return true;
    }
}

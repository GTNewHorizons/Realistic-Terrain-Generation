package highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

import highlands.Highlands;

public class BlockHighlandsStairs extends BlockStairs {

    public BlockHighlandsStairs(Block modelBlock, int meta) {
        super(modelBlock, meta);
        this.setCreativeTab(Highlands.tabHighlands);
    }
}

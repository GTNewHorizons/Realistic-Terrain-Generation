package highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import highlands.api.HighlandsBlocks;

public class ItemSlabPlanks extends ItemSlab {

    public ItemSlabPlanks(Block block) {
        super(block, (BlockSlab) HighlandsBlocks.hlplankhalf, (BlockSlab) HighlandsBlocks.hlplankhalfdouble, false);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
}

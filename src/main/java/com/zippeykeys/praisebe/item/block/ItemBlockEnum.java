package com.zippeykeys.praisebe.item.block;

import com.zippeykeys.praisebe.block.base.BlockEnum;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.MathUtil;

import lombok.val;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEnum<T extends Enum<T> & Localize> extends ItemBlock {

    public ItemBlockEnum(BlockEnum<T> blockIn) {
        super(blockIn);

        if (blockIn.getValues().length != 0)
            setHasSubtypes(true);
    }

    @SuppressWarnings("unchecked")
    @Override
    public BlockEnum<T> getBlock() {
        return (BlockEnum<T>) super.getBlock();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        val block = getBlock();
        return block.getUnlocalizedName()
                + block.getValues()[MathUtil.clamp(stack.getItemDamage(), 0, getBlock().getValues().length - 1)]
                        .getName();
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}
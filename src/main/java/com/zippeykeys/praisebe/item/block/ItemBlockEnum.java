package com.zippeykeys.praisebe.item.block;

import com.zippeykeys.praisebe.block.base.AbstractBlockEnum;
import com.zippeykeys.praisebe.util.MathUtil;

import org.jetbrains.annotations.NotNull;

import lombok.val;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class ItemBlockEnum<T extends Enum<T> & IStringSerializable> extends ItemBlock {

    public ItemBlockEnum(AbstractBlockEnum<T> block) {
        super(block);

        if (block.getValues().length != 0)
            setHasSubtypes(true);
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull AbstractBlockEnum<T> getBlock() {
        return (AbstractBlockEnum<T>) super.getBlock();
    }

    @Override
    public @NotNull String getUnlocalizedName(ItemStack stack) {
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
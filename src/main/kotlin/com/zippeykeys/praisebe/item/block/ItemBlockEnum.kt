package com.zippeykeys.praisebe.item.block

import com.zippeykeys.praisebe.block.base.BlockEnum
import com.zippeykeys.praisebe.iface.ILocalize
import net.minecraft.item.ItemStack
import net.minecraft.util.math.MathHelper.clamp


class ItemBlockEnum<T>(blockIn: BlockEnum<T>) : PBItemBlock(blockIn) where T : Enum<T>, T : ILocalize {
    init {
        if (blockIn.values.isNotEmpty()) {
            setHasSubtypes(true)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun getBlock(): BlockEnum<T> {
        return super.getBlock() as BlockEnum<T>
    }

    override fun getUnlocalizedName(stack: ItemStack): String {
        val block = getBlock()
        return block.unlocalizedName + block.values[clamp(stack.itemDamage, 0, getBlock().values.size - 1)]
                .getName()
    }

    override fun getMetadata(damage: Int): Int {
        return damage
    }
}
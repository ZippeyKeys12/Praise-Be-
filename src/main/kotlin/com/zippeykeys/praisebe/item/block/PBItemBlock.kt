package com.zippeykeys.praisebe.item.block

import com.zippeykeys.praisebe.block.base.PBBlock
import com.zippeykeys.praisebe.iface.ILocalize
import net.minecraft.item.ItemBlock


open class PBItemBlock constructor(blockIn: PBBlock, private val actualName: String = blockIn.name) : ItemBlock(blockIn), ILocalize {
    override fun getName(): String {
        return actualName
    }

    override fun getUnlocalizedName(): String {
        return super<ItemBlock>.getUnlocalizedName()
    }

    override val prefix: String
        get() = "item"
}
package com.zippeykeys.praisebe.block.tile.base

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.ITickable


class TileEntityIdolBase : PBTileEntity(), ITickable {
    var facing: Int = 0

    override fun readFromNBT(tagCompound: NBTTagCompound) {
        super.readFromNBT(tagCompound)
        facing = tagCompound.getInteger("facing")
    }

    override fun writeToNBT(tagCompound: NBTTagCompound): NBTTagCompound {
        super.writeToNBT(tagCompound)
        tagCompound.setInteger("facing", facing)
        return tagCompound
    }

    override fun update() {}
}
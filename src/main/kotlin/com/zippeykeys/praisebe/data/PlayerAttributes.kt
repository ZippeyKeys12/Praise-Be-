package com.zippeykeys.praisebe.data

import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.common.util.INBTSerializable


class PlayerAttributes : INBTSerializable<NBTTagCompound> {
    var graceTaint: Int = DEF_GRACE_TAINT
        private set

    companion object {
        const val MAX = 100

        const val MIN = -100

        const val DEF_GRACE_TAINT = 0
    }

    constructor() : this(DEF_GRACE_TAINT)

    constructor(graceTaintIn: Int) {
        graceTaint = graceTaintIn
    }

    constructor(nbt: NBTTagCompound) {
        deserializeNBT(nbt)
    }

    override fun serializeNBT(): NBTTagCompound {
        val tagCompound = NBTTagCompound()
        tagCompound.setInteger("grace_taint", graceTaint)
        return tagCompound
    }

    override fun deserializeNBT(nbt: NBTTagCompound) {
        graceTaint = nbt.getInteger("grace_taint")
    }
}
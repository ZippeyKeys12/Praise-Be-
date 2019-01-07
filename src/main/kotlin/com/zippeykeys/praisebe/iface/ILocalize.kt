package com.zippeykeys.praisebe.iface

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.util.getResource
import net.minecraft.util.IStringSerializable
import net.minecraft.util.ResourceLocation


interface ILocalize : IStringSerializable {
    val prefix: String

    val resource: ResourceLocation
        get() = getResource(name)

    fun getUnlocalizedName(): String {
        return "$prefix.$name"
    }

    fun getLocalizedName(): String {
        return Reference.INSTANCE.proxy()
                .localize(getUnlocalizedName() + ".name")
    }

    fun getLocalizedDescription(): String {
        return Reference.INSTANCE.proxy()
                .localize(getUnlocalizedName() + ".desc")
    }
}
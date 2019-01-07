package com.zippeykeys.praisebe.compat

import com.zippeykeys.praisebe.iface.ILocalize
import net.minecraftforge.fml.common.Loader

enum class EMod(private val actualName: String) : ILocalize {
    ;

    override val prefix: String
        get() = "mod"

    override fun getName(): String {
        return actualName
    }

    fun exists(): Boolean {
        return Loader.isModLoaded(name)
    }
}
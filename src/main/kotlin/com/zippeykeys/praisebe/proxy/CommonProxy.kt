@file:Suppress("DEPRECATION")

package com.zippeykeys.praisebe.proxy

import net.minecraft.util.text.translation.I18n
import net.minecraftforge.fml.relauncher.Side


class CommonProxy : IProxy {
    override val physicalSide: Side
        get() = Side.SERVER

    override fun type(): String {
        return "Server"
    }

    override fun localize(translateKey: String, vararg parameters: Any): String {
        return I18n.translateToLocalFormatted(translateKey, *parameters)
    }
}

package com.zippeykeys.praisebe.proxy

import net.minecraft.client.resources.I18n
import net.minecraftforge.fml.relauncher.Side


class ClientProxy : IProxy {

    override val physicalSide: Side
        get() = Side.CLIENT

    override fun type(): String {
        return "Client"
    }

    override fun localize(translateKey: String, vararg parameters: Any): String {
        return I18n.format(translateKey, *parameters)
    }
}

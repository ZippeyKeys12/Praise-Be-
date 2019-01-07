package com.zippeykeys.praisebe.block

import com.zippeykeys.praisebe.iface.ILocalize

enum class EOreBlock(private val actualName: String) : ILocalize {
    // Normal //
    GALLIUM("gallium"),
    PLATINUM("platinum"),
    TITANIUM("titanium"),
    TUNGSTEN("tungsten"),
    CHROMIUM("chromium"),
    // Enchanted //
    GALVORN("galvorn"),
    MITHRIL("mithril"),
    ORICHALCUM("orichalcum"),
    ADAMANTITE("adamantite"),
    SCARLETITE("scarletite");

    override val prefix: String
        get() = "building"

    override fun getName(): String {
        return actualName
    }
}
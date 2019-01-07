package com.zippeykeys.praisebe.block

import com.zippeykeys.praisebe.iface.ILocalize

enum class EBuildingBlock(private val actualName: String) : ILocalize {
    MARBLE("marble"),
    BASALT("basalt");

    override val prefix: String
        get() = "building"

    override fun getName(): String {
        return actualName
    }
}
package com.zippeykeys.praisebe.deity

import com.zippeykeys.praisebe.iface.ILocalize
import net.minecraftforge.registries.IForgeRegistryEntry


data class Affinity constructor(private val name: String, val primaryDeity: Deity, val secondaryDeity: Deity) : IForgeRegistryEntry.Impl<Affinity>(), ILocalize {
    override val prefix: String
        get() = "deity.affinity"

    override fun getName(): String {
        return name;
    }
}
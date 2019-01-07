package com.zippeykeys.praisebe.item.base

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.iface.ILocalize
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import java.util.Arrays
import java.util.HashMap
import java.util.Objects


open class PBItem(private val actualName: String, vararg creativeTabs: CreativeTabs) : Item(), ILocalize {
    val oreDictEntries: MutableMap<String, ItemStack> = HashMap()

    override val prefix: String
        get() = "item"

    init {
        @Suppress("LeakingThis")
        registryName = resource
        unlocalizedName = Reference.MOD_ID + "." + registryName!!.resourcePath
        Arrays.stream(creativeTabs)
                .filter { Objects.nonNull(it) }
                .forEach { creativeTab = it }
    }

    override fun getName(): String {
        return actualName
    }

    override fun getUnlocalizedName(): String {
        return super<Item>.getUnlocalizedName()
    }

    fun addOreDictEntry(entry: String) {
        oreDictEntries[entry] = ItemStack(this)
    }

    fun addAllOreDictEntry(entriesIn: Collection<String>) {
        for (entry in entriesIn) {
            addOreDictEntry(entry)
        }
    }
}
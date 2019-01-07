package com.zippeykeys.praisebe

import com.zippeykeys.praisebe.block.ModBlocks
import com.zippeykeys.praisebe.proxy.IProxy
import com.zippeykeys.praisebe.util.getItem
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Mod.Instance
import net.minecraftforge.fml.common.SidedProxy
import java.util.Objects


object Reference {
    const val MOD_ID = "praisebe"

    const val MOD_NAME = "Praise Be!"

    const val MOD_VERSION = "@VERSION@"

    const val MOD_PACKAGE = "com.zippeykeys.praisebe"

    const val LANGUAGE_ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"

    const val MOD_DEPENDENCIES = "required-after:forgelin"

    const val PROXY_SERVER = "$MOD_PACKAGE.proxy.CommonProxy"

    const val PROXY_CLIENT = "$MOD_PACKAGE.proxy.ClientProxy"

    @Instance(MOD_ID)
    lateinit var INSTANCE: PraiseBe

    @SidedProxy(clientSide = PROXY_CLIENT, serverSide = PROXY_SERVER)
    var PROXY: IProxy? = null

    val TAB_GENERAL: CreativeTabs = object : CreativeTabs("praisebe") {
        override fun getTabIconItem(): ItemStack {
            return ItemStack(Item.getItemFromBlock(ModBlocks.BUILDING_BLOCK))
        }
    }

    val TAB_CELESTIAL: CreativeTabs = object : CreativeTabs("praisebe.celestial") {
        override fun getTabIconItem(): ItemStack {
            return ItemStack(Objects.requireNonNull<Item>(getItem("minecraft:dirt")))
        }
    }

    val TAB_TERRESTRIAL: CreativeTabs = object : CreativeTabs("praisebe.terrestrial") {
        override fun getTabIconItem(): ItemStack {
            return ItemStack(Objects.requireNonNull<Item>(getItem("minecraft:tnt")))
        }
    }

    val TAB_ETHEREAL: CreativeTabs = object : CreativeTabs("praisebe.ethereal") {
        override fun getTabIconItem(): ItemStack {
            return ItemStack(Objects.requireNonNull<Item>(getItem("minecraft:stone")))
        }
    }
}
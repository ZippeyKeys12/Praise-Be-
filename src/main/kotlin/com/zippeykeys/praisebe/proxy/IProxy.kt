package com.zippeykeys.praisebe.proxy

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.relauncher.Side
import org.apache.logging.log4j.Logger


interface IProxy {
    val physicalSide: Side

    fun preInit(logger: Logger, event: FMLPreInitializationEvent) {
        logger.info("PreInitializing " + type() + " Proxy")
    }

    fun init(logger: Logger, event: FMLInitializationEvent) {
        logger.info("Initializing " + type() + " Proxy")
    }

    fun postInit(logger: Logger, event: FMLPostInitializationEvent) {
        logger.info("PostInitializing " + type() + " Proxy")
    }

    fun type(): String

    fun localize(translateKey: String, vararg parameters: Any): String
}

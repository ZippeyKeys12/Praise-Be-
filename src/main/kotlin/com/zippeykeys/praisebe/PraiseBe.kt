package com.zippeykeys.praisebe

import com.zippeykeys.praisebe.component.DaggerPraiseBeComponent
import com.zippeykeys.praisebe.component.PraiseBeComponent
import com.zippeykeys.praisebe.proxy.IProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger
import javax.inject.Inject


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION,
        modLanguageAdapter = Reference.LANGUAGE_ADAPTER, dependencies = Reference.MOD_DEPENDENCIES, useMetadata = true)
class PraiseBe(private val delegate: PraiseBeComponent = DaggerPraiseBeComponent.create()) :
        PraiseBeComponent by delegate {
    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var proxy: IProxy

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        inject(this)
        logger.info("Starting PreInitialization")
        event.modMetadata.version = Reference.MOD_VERSION
        proxy.preInit(logger, event)
        logger.info("PreInitialization Completed")
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        logger.info("Starting Initialization")
        proxy.init(logger, event)
        logger.info("Initialization Completed")
    }

    @EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        logger.info("Starting PostInitialization")
        proxy.postInit(logger, event)
        logger.info("PostInitialization Completed")
    }
}
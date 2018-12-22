package com.zippeykeys.praisebe;

import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.proxy.IProxy;

import org.apache.logging.log4j.Logger;

import lombok.experimental.Delegate;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES, useMetadata = true)
public class PraiseBe {
    @Delegate
    private final PraiseBeComponent content;

    Logger logger;
    IProxy proxy;

    public PraiseBe() {
        content = DaggerPraiseBeComponent.create();
    }

    public PraiseBe inject(Logger loggerIn, IProxy proxyIn) {
        this.logger = loggerIn;
        this.proxy = proxyIn;
        return this;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        inject(this);

        logger.info("Starting PreInitialization");

        event.getModMetadata().version = Reference.MOD_VERSION;
        proxy.preInit(logger, event);

        logger.info("PreInitialization Completed");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Starting Initialization");

        proxy.init(logger, event);

        logger.info("Initialization Completed");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("Starting PostInitialization");

        proxy.postInit(logger, event);

        logger.info("PostInitialization Completed");
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void loadComplete(FMLLoadCompleteEvent event) {
        Deity.Registry.DEITIES.getValues() //
                .forEach(Deity.Registry.INSTANCE::register);
    }
}
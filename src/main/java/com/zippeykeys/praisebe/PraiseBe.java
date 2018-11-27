package com.zippeykeys.praisebe;

import com.zippeykeys.praisebe.common.util.Reference;
import com.zippeykeys.praisebe.proxy.IProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES, useMetadata = true)
public class PraiseBe {
    @Instance(Reference.MOD_ID)
    public static PraiseBe instance;

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static IProxy PROXY;

    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_NAME);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting PreInitialization");

        event.getModMetadata().version = Reference.MOD_VERSION;
        PROXY.preInit(event);

        LOGGER.info("PreInitialization Completed");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Starting Initialization");

        PROXY.init(event);

        LOGGER.info("Initialization Completed");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting PostInitialization");

        PROXY.postInit(event);

        LOGGER.info("PostInitialization Completed");
    }
}

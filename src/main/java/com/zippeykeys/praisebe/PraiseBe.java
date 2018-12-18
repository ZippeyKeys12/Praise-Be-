package com.zippeykeys.praisebe;

import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.proxy.IProxy;
import com.zippeykeys.praisebe.util.ModRegistry;
import com.zippeykeys.praisebe.util.Reference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES, useMetadata = true)
public class PraiseBe {

    @Instance(Reference.MOD_ID)
    public static PraiseBe INSTANCE = new PraiseBe();

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static IProxy PROXY;

    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_NAME);

    public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE
            .newSimpleChannel(Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting PreInitialization");

        event.getModMetadata().version = Reference.MOD_VERSION;
        PROXY.preInit(LOGGER, event);

        LOGGER.info("PreInitialization Completed");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Starting Initialization");

        PROXY.init(LOGGER, event);

        LOGGER.info("Initialization Completed");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting PostInitialization");

        PROXY.postInit(LOGGER, event);
        PraiseBe.info(ModRegistry.BLOCKS.toString());

        LOGGER.info("PostInitialization Completed");
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void loadComplete(FMLLoadCompleteEvent event) {
        Deity.Registry.DEITIES.getValues() //
                .forEach(Deity.Registry.INSTANCE::register);
    }

    public static void debug(String messages) {
        LOGGER.debug(messages);
    }

    public static void info(String messages) {
        LOGGER.info(messages);
    }

    public static void warn(String messages) {
        LOGGER.warn(messages);
    }

    public static void error(String messages) {
        LOGGER.error(messages);
    }

    public static void fatal(String messages) {
        LOGGER.fatal(messages);
    }
}

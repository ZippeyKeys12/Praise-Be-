package com.zippeykeys.praisebe;

import com.zippeykeys.praisebe.data.PBWorldData;
import com.zippeykeys.praisebe.proxy.IProxy;
import com.zippeykeys.praisebe.registry.DeityRegistry;
import com.zippeykeys.praisebe.util.Reference;
import com.zippeykeys.praisebe.util.Util;

import org.apache.logging.log4j.Logger;

import lombok.Getter;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES, useMetadata = true)
public class PraiseBe {

    @Instance(Reference.MOD_ID)
    public static PraiseBe INSTANCE = new PraiseBe();

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static IProxy PROXY;

    public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE
            .newSimpleChannel(Reference.MOD_ID);

    @Getter
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Starting PreInitialization");

        event.getModMetadata().version = Reference.MOD_VERSION;
        PROXY.preInit(logger, event);

        logger.info("PreInitialization Completed");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Starting Initialization");

        PROXY.init(logger, event);

        logger.info("Initialization Completed");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("Starting PostInitialization");

        PROXY.postInit(logger, event);

        logger.info("PostInitialization Completed");
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void loadComplete(FMLLoadCompleteEvent event) {
        DeityRegistry.DEITIES.getValues() //
                .forEach(DeityRegistry.INSTANCE::register);
    }

    public static void debug(String messages) {
        logger.debug(messages);
    }

    public static void info(String messages) {
        logger.info(messages);
    }

    public static void warn(String messages) {
        logger.warn(messages);
    }

    public static void error(String messages) {
        logger.error(messages);
    }

    public static void fatal(String messages) {
        logger.fatal(messages);
    }
}

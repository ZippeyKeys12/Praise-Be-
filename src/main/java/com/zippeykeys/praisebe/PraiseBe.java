package com.zippeykeys.praisebe;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;

import com.zippeykeys.praisebe.block.AbstractPBBlock;
import com.zippeykeys.praisebe.block.ModBlocks;
import com.zippeykeys.praisebe.proxy.IProxy;
import com.zippeykeys.praisebe.util.ModRegistry;
import com.zippeykeys.praisebe.util.Reference;

import org.apache.logging.log4j.Logger;

import lombok.Getter;
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
    public static PraiseBe INSTANCE;

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static IProxy PROXY;

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

    public static void debug(final String messages) {
        logger.debug(messages);
    }

    public static void info(final String messages) {
        logger.info(messages);
    }

    public static void warn(final String messages) {
        logger.warn(messages);
    }

    public static void error(final String messages) {
        logger.error(messages);
    }

    public static void fatal(final String messages) {
        logger.fatal(messages);
    }
}

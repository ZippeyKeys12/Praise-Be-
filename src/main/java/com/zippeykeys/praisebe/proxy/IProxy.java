package com.zippeykeys.praisebe.proxy;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;


public interface IProxy{
    default void preInit(Logger logger, FMLPreInitializationEvent event){
        logger.info("PreInitializing " + type() + " Proxy");
    }

    default void init(Logger logger, FMLInitializationEvent event){
        logger.info("Initializing " + type() + " Proxy");
    }

    default void postInit(Logger logger, FMLPostInitializationEvent event){
        logger.info("PostInitializing " + type() + " Proxy");
    }

    String type();

    String localize(String translateKey, Object... parameters);

    Side getPhysicalSide();
}

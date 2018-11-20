package com.zippeykeys.praisebe.proxy;

import com.zippeykeys.praisebe.PraiseBe;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
    default void preInit(FMLPreInitializationEvent event) {
        PraiseBe.LOGGER.info("PreInitializing" + type() + "Proxy");
    }

    default void init(FMLInitializationEvent event) {
        PraiseBe.LOGGER.info("Initializing" + type() + "Proxy");
    }

    default void postInit(FMLPostInitializationEvent event) {
        PraiseBe.LOGGER.info("PostInitializing" + type() + "Proxy");
    }

    default String type() {
        return " ";
    }
}

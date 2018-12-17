package com.zippeykeys.praisebe.proxy;

import org.apache.logging.log4j.Logger;

import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@SuppressWarnings("deprecation")
public class ServerProxy implements IProxy {
    @Override
    public void preInit(Logger logger, FMLPreInitializationEvent event) {
        IProxy.super.preInit(logger, event);
    }

    @Override
    public void init(Logger logger, FMLInitializationEvent event) {
        IProxy.super.init(logger, event);
    }

    @Override
    public void postInit(Logger logger, FMLPostInitializationEvent event) {
        IProxy.super.postInit(logger, event);
    }

    @Override
    public String type() {
        return "Server";
    }

    @Override
    public String localize(String key, Object... format) {
        return I18n.translateToLocalFormatted(key, format);
    }

    @Override
    public Side getPhysicalSide() {
        return Side.SERVER;
    }
}

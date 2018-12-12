package com.zippeykeys.praisebe.proxy;

import org.apache.logging.log4j.Logger;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy implements IProxy {
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
        return "Client";
    }

    @Override
    public String localize(String translateKey, Object... parameters) {
        return I18n.format(translateKey, parameters);
    }

    @Override
    public Side getPhysicalSide() {
        return Side.CLIENT;
    }
}

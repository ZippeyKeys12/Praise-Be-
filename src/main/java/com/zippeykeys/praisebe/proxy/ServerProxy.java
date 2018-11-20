package com.zippeykeys.praisebe.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ServerProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        IProxy.super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        IProxy.super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        IProxy.super.postInit(event);
    }

    @Override
    public String type()
    {
        return " Server ";
    }
}

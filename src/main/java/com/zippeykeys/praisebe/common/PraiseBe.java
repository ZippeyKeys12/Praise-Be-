package com.zippeykeys.praisebe.common;

import com.google.common.collect.Lists;
import com.zippeykeys.praisebe.common.handler.RegisterBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = PraiseBe.MODID, name = PraiseBe.MODNAME, version = PraiseBe.VERSION, dependencies = PraiseBe.DEPENDENCIES)
public class PraiseBe{
    // Mod Info
    public static final String MODID = "praisebe";
    public static final String MODNAME = "Praise Be!";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "";

    @Mod.Instance
    public static PraiseBe instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        Lists.newArrayList(RegisterBlocks.class).forEach(MinecraftForge.EVENT_BUS::register);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    }
}

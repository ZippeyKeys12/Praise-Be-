package com.zippeykeys.praisebe.common;

import com.zippeykeys.praisebe.common.handler.RegisterBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = PraiseBe.MOD_ID, name = PraiseBe.NAME, version = PraiseBe.VERSION, dependencies = PraiseBe.DEPENDENCIES, updateJSON = PraiseBe.UPDATE_JSON)
public class PraiseBe
{
    // Mod Info
    public static final String MOD_ID = "praisebe";
    public static final String NAME = "Praise Be!";
    public static final String VERSION = "${version}";
    public static final String DEPENDENCIES = "";
    public static final String UPDATE_JSON = "https://raw.github.com/ZippeyKeys12/PraiseBe/master/update.json";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Instance(MOD_ID)
    public static PraiseBe instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(RegisterBlocks.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}

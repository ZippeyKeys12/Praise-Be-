package com.zippeykeys.praisebe;

import com.zippeykeys.praisebe.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = PraiseBe.MOD_ID, name = PraiseBe.NAME, version = PraiseBe.VERSION, dependencies = PraiseBe.DEPENDENCIES, updateJSON = PraiseBe.UPDATE_JSON)
public class PraiseBe {
    // Mod Info
    public static final String MOD_ID = "praisebe";
    public static final String NAME = "Praise Be!";
    public static final String VERSION = "${version}";
    public static final String PACKAGE = "com.zippeykeys.praisebe";
    public static final String PROXY_SERVER = PACKAGE + ".proxy.ServerProxy";
    public static final String PROXY_CLIENT = PACKAGE + ".proxy.ClientProxy";
    public static final String DEPENDENCIES = "";
    public static final String UPDATE_JSON = "https://raw.github.com/ZippeyKeys12/PraiseBe/master/update.json";

    @Instance(MOD_ID)
    public static PraiseBe instance;

    @SidedProxy(clientSide = PROXY_CLIENT, serverSide = PROXY_SERVER)
    public static IProxy PROXY;

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting PreInitialization");
        PROXY.preInit(event);
        LOGGER.info("PreInitialization Completed");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Starting Initialization");
        PROXY.init(event);
        LOGGER.info("Initialization Completed");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting PostInitialization");
        PROXY.postInit(event);
        LOGGER.info("PostInitialization Completed");
    }
}

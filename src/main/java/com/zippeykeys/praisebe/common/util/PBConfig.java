package com.zippeykeys.praisebe.common.util;

import org.jetbrains.annotations.NotNull;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
public class PBConfig {
    @Config.Comment("Compatibility Settings")
    public static final Compatibility COMPATIBILITY = new Compatibility();

    public static class Compatibility {
    }

    @SubscribeEvent
    public static void onConfigChanged(@NotNull ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        }
    }
}

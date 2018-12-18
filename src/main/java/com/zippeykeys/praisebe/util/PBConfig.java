package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@UtilityClass
@Config(modid = Reference.MOD_ID)
public class PBConfig {
    @Config.Comment("Compatibility Settings")
    public static final Compatibility COMPATIBILITY = new Compatibility();

    public static class Compatibility {
    }

    @SubscribeEvent
    public static void onConfigChanged(@NotNull OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        }
    }
}

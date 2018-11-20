package com.zippeykeys.praisebe.common.util;

import com.zippeykeys.praisebe.PraiseBe;

import org.jetbrains.annotations.NotNull;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = PraiseBe.MOD_ID)
public class PBConfig {
    @Config.Comment("Visual Settings")
    public static final Visual VISUAL = new Visual();

    public static class Visual {
        @Config.Name("Idols glow")
        @Config.Comment("Determines whether idols emit light")
        public boolean idolGlow = true;
    }

    @SubscribeEvent
    public static void onConfigChanged(@NotNull ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(PraiseBe.MOD_ID)) {
            ConfigManager.sync(PraiseBe.MOD_ID, Config.Type.INSTANCE);
        }
    }
}

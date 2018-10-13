package com.zippeykeys.praisebe.common.util;

import com.zippeykeys.praisebe.common.PraiseBe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;


@Config(modid = PraiseBe.MODID)
public class PBConfig{
    @Config.Comment("Visual Settings")
    public static final Visual VISUAL = new Visual();

    public static class Visual{
        @Config.Name("Idols glow")
        @Config.Comment("Determines whether idols emit light")
        public boolean idolGlow = true;
    }

    @SubscribeEvent
    public static void onConfigChanged(@NotNull ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equals(PraiseBe.MODID)){
            ConfigManager.sync(PraiseBe.MODID, Config.Type.INSTANCE);
        }
    }
}

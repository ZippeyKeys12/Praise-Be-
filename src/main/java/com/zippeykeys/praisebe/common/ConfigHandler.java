package com.zippeykeys.praisebe.common;

import net.minecraftforge.common.config.Config;


@Config(modid = PraiseBe.MODID)
public class ConfigHandler{
    @Config.Name("Idols glow")
    @Config.Comment("Determines whether idols emit light")
    public static boolean idolGlow = true;
}

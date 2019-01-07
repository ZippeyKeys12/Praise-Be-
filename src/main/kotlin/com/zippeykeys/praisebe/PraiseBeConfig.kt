package com.zippeykeys.praisebe

import net.minecraftforge.common.config.Config
import net.minecraftforge.common.config.ConfigManager
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Config(modid = Reference.MOD_ID)
object PraiseBeConfig {
    class Compatibility

    @Config.Comment("Compatibility Settings")
    val COMPATIBILITY = Compatibility()

    @SubscribeEvent
    fun onConfigChanged(event: OnConfigChangedEvent) {
        if (event.modID == Reference.MOD_ID) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE)
        }
    }
}

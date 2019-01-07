package com.zippeykeys.praisebe.module

import dagger.Module
import dagger.Provides
import net.minecraft.world.World
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import javax.inject.Singleton


@Module
class VanillaModule {
    @Provides
    @Singleton
    @SideOnly(Side.SERVER)
    fun providesWorld(): World {
        return FMLCommonHandler.instance()
                .minecraftServerInstance.entityWorld
    }
}
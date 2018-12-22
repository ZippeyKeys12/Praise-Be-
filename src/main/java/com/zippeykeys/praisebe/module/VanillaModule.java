package com.zippeykeys.praisebe.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

@Module
public class VanillaModule {
    @Provides
    @Singleton
    public static World providesWorld() {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld();
    }
}
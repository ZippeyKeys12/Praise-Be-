package com.zippeykeys.praisebe.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Module
public class VanillaModule{
    @Provides
    @Singleton
    @SideOnly(Side.SERVER)
    public static World providesWorld(){
        return FMLCommonHandler.instance()
          .getMinecraftServerInstance()
          .getEntityWorld();
    }
}
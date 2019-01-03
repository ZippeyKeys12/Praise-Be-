package com.zippeykeys.praisebe;

import javax.inject.Singleton;

import com.zippeykeys.praisebe.proxy.IProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;

import dagger.Module;
import dagger.Provides;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;


@Module
public class PraiseBeModule{
    @Contract(pure = true)
    @Provides
    @Singleton
    public static PraiseBe provideInstance(){
        return Reference.INSTANCE;
    }

    @Contract(pure = true)
    @Provides
    @Singleton
    public static IProxy provideProxy(){
        return Reference.PROXY;
    }

    @Provides
    @Singleton
    public static SimpleNetworkWrapper providePacketHandler(){
        return NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    }

    @Provides
    @Singleton
    public static Logger getLogger(){
        return LogManager.getLogger(Reference.MOD_NAME);
    }
}
package com.zippeykeys.praisebe;

import javax.inject.Singleton;

import com.zippeykeys.praisebe.proxy.IProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dagger.Module;
import dagger.Provides;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Module
public class PraiseBeModule {
    private static final SimpleNetworkWrapper packetHandler = NetworkRegistry.INSTANCE
            .newSimpleChannel(Reference.MOD_ID);

    @Provides
    @Singleton
    public static PraiseBe provideInstance() {
        return Reference.INSTANCE;
    }

    @Provides
    @Singleton
    public static IProxy provideProxy() {
        return Reference.PROXY;
    }

    @Provides
    @Singleton
    public static SimpleNetworkWrapper providePacketHandler() {
        return packetHandler;
    }

    @Provides
    @Singleton
    public static Logger getLogger() {
        return LogManager.getLogger(Reference.MOD_NAME);
    }
}
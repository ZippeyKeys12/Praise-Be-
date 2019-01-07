package com.zippeykeys.praisebe.module

import com.zippeykeys.praisebe.PraiseBe
import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.proxy.IProxy
import dagger.Module
import dagger.Provides
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import javax.inject.Singleton


@Module
class PraiseBeModule {
    val logger: Logger
        @Provides
        @Singleton
        get() = LogManager.getLogger(Reference.MOD_NAME)

    @Provides
    @Singleton
    fun provideInstance(): PraiseBe {
        return Reference.INSTANCE
    }

    @Provides
    @Singleton
    fun provideProxy(): IProxy {
        return Reference.PROXY!!
    }

    @Provides
    @Singleton
    fun providePacketHandler(): SimpleNetworkWrapper {
        return NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID)
    }
}
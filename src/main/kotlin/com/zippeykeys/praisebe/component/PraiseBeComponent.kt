package com.zippeykeys.praisebe.component

import com.zippeykeys.praisebe.PraiseBe
import com.zippeykeys.praisebe.data.PBWorldData
import com.zippeykeys.praisebe.module.DataModule
import com.zippeykeys.praisebe.module.PraiseBeModule
import com.zippeykeys.praisebe.module.VanillaModule
import com.zippeykeys.praisebe.proxy.IProxy
import com.zippeykeys.praisebe.registry.DeityRegistry
import dagger.Component
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.apache.logging.log4j.Logger
import javax.inject.Singleton


@Singleton
@Component(modules = [PraiseBeModule::class, VanillaModule::class, DataModule::class])
interface PraiseBeComponent {
    fun proxy(): IProxy

    fun packetHandler(): SimpleNetworkWrapper

    fun logger(): Logger

    @SideOnly(Side.SERVER)
    fun world(): World

    @SideOnly(Side.SERVER)
    fun worldData(): PBWorldData

    @SideOnly(Side.SERVER)
    fun deityRegistry(): DeityRegistry

    fun inject(instance: PraiseBe)
}
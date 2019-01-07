package com.zippeykeys.praisebe.module

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.block.multi.Multiblock
import com.zippeykeys.praisebe.data.PBWorldData
import com.zippeykeys.praisebe.deity.Affinity
import com.zippeykeys.praisebe.deity.Deity
import com.zippeykeys.praisebe.util.getResource
import dagger.Module
import dagger.Provides
import net.minecraft.world.World
import net.minecraft.world.storage.MapStorage
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry
import net.minecraftforge.registries.RegistryBuilder
import org.apache.logging.log4j.Logger
import java.util.Objects
import javax.inject.Singleton


@EventBusSubscriber(modid = Reference.MOD_ID)
@Module(includes = [PraiseBeModule::class, VanillaModule::class])
class DataModule {
    private lateinit var multiblocks: IForgeRegistry<Multiblock>

    private lateinit var deities: IForgeRegistry<Deity>

    private lateinit var affinities: IForgeRegistry<Affinity>

    @SubscribeEvent
    fun registerRegistries(event: RegistryEvent.NewRegistry) {
        multiblocks = RegistryBuilder<Multiblock>()
                .setName(getResource("multiblocks"))
                .setIDRange(0, Integer.MAX_VALUE - 1)
                .setType(Multiblock::class.java)
                .create()
        deities = RegistryBuilder<Deity>()
                .setName(getResource("deities"))
                .setIDRange(0, Integer.MAX_VALUE - 1)
                .setType(Deity::class.java)
                .create()
        affinities = RegistryBuilder<Affinity>()
                .setName(getResource("affinities"))
                .setIDRange(0, Integer.MAX_VALUE - 1)
                .setType(Affinity::class.java)
                .create()
    }

    @Provides
    @Singleton
    @SideOnly(Side.SERVER)
    fun provideWorldData(logger: Logger, world: World): PBWorldData {
        logger.info("Loading WorldData")
        val storage = world.mapStorage
        var instance = Objects.requireNonNull<MapStorage>(storage)
                .getOrLoadData(
                        PBWorldData::class.java,
                        PBWorldData.ID
                ) as PBWorldData?
        if (instance == null) {
            logger.info("No Existing WorldData")
            instance = PBWorldData()
            storage!!.setData(PBWorldData.ID, instance)
            logger.info("Created New WorldData")
        }
        logger.info("WorldData Loaded")
        return instance
    }

    @Provides
    @Singleton
    fun provideMultiblockForgeRegistry(): IForgeRegistry<Multiblock> {
        return multiblocks
    }

    @Provides
    @Singleton
    fun provideDeityForgeRegistry(): IForgeRegistry<Deity> {
        return deities
    }

    @Provides
    @Singleton
    fun provideAffinityForgeRegistry(): IForgeRegistry<Affinity> {
        return affinities
    }
}
package com.zippeykeys.praisebe.module;

import java.util.Objects;

import javax.inject.Singleton;

import com.zippeykeys.praisebe.PraiseBeModule;
import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.data.PBWorldData;
import com.zippeykeys.praisebe.deity.Affinity;
import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.util.Util;

import org.apache.logging.log4j.Logger;

import dagger.Module;
import dagger.Provides;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@EventBusSubscriber(modid = Reference.MOD_ID)
@Module(includes = { PraiseBeModule.class, VanillaModule.class })
public class DataModule {
    private static IForgeRegistry<Deity> DEITIES;

    private static IForgeRegistry<Affinity> AFFINITIES;

    @SubscribeEvent
    public static void registerRegistries(RegistryEvent.NewRegistry event) {
        DEITIES = new RegistryBuilder<Deity>() //
                .setName(Util.getResource("deities")) //
                .setIDRange(0, Integer.MAX_VALUE - 1) //
                .setType(Deity.class) //
                .create();

        AFFINITIES = new RegistryBuilder<Affinity>() //
                .setName(Util.getResource("affinities")) //
                .setIDRange(0, Integer.MAX_VALUE - 1) //
                .setType(Affinity.class) //
                .create();
    }

    @Provides
    @Singleton
    @SideOnly(Side.SERVER)
    public static PBWorldData provideWorldData(Logger logger, World world) {
        logger.info("Loading WorldData");
        MapStorage storage = world.getMapStorage();
        PBWorldData instance = (PBWorldData) Objects.requireNonNull(storage).getOrLoadData(PBWorldData.class,
                PBWorldData.ID);
        if (instance == null) {
            logger.info("No Existing WorldData");
            instance = new PBWorldData();
            storage.setData(PBWorldData.ID, instance);
            logger.info("Created New WorldData");
        }
        logger.info("WorldData Loaded");
        return instance;
    }

    @Provides
    @Singleton
    public static IForgeRegistry<Deity> provideDeityForgeRegistry() {
        return DEITIES;
    }

    @Provides
    @Singleton
    public static IForgeRegistry<Affinity> provideAffinityForgeRegistry() {
        return AFFINITIES;
    }
}
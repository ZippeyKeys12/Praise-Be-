package com.zippeykeys.praisebe.module;

import java.util.Objects;

import javax.inject.Singleton;

import com.zippeykeys.praisebe.data.PBWorldData;

import org.apache.logging.log4j.Logger;

import dagger.Module;
import dagger.Provides;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;

@Module
public class DataModule {
    @Provides
    @Singleton
    public static PBWorldData providesWorldData(Logger logger, World world) {
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
}
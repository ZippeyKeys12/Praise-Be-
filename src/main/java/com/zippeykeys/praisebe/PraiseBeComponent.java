package com.zippeykeys.praisebe;

import javax.inject.Singleton;

import com.zippeykeys.praisebe.data.PBWorldData;
import com.zippeykeys.praisebe.module.DataModule;
import com.zippeykeys.praisebe.module.VanillaModule;
import com.zippeykeys.praisebe.proxy.IProxy;

import org.apache.logging.log4j.Logger;

import dagger.Component;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Singleton
@Component(modules = { //
        PraiseBeModule.class, //
        VanillaModule.class, //
        DataModule.class //
})
public interface PraiseBeComponent {
    PraiseBe mod();

    SimpleNetworkWrapper packetHandler();

    Logger logger();

    IProxy proxy();

    World world();

    PBWorldData worldData();

    default PraiseBe inject(PraiseBe obj) {
        return obj.inject(logger(), proxy());
    }
}
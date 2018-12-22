package com.zippeykeys.praisebe;

import javax.inject.Singleton;

import com.zippeykeys.praisebe.data.PBWorldData;
import com.zippeykeys.praisebe.module.DataModule;
import com.zippeykeys.praisebe.module.VanillaModule;
import com.zippeykeys.praisebe.proxy.IProxy;
import com.zippeykeys.praisebe.registry.DeityRegistry;

import org.apache.logging.log4j.Logger;

import dagger.Component;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Singleton
@Component(modules = { //
        PraiseBeModule.class, //
        VanillaModule.class, //
        DataModule.class //
})
public interface PraiseBeComponent {
    IProxy proxy();

    SimpleNetworkWrapper packetHandler();

    Logger logger();

    @SideOnly(Side.SERVER)
    World world();

    @SideOnly(Side.SERVER)
    PBWorldData worldData();

    @SideOnly(Side.SERVER)
    DeityRegistry deityRegistry();

    void injectMembers(PraiseBe instance);
}
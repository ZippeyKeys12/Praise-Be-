package com.zippeykeys.praisebe.common.handler;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class RegisterBlocks{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        // event.getRegistry().registerAll(Lists.newArrayList().toArray());
    }
}

package com.zippeykeys.praisebe.common.handler;

import com.zippeykeys.praisebe.common.PraiseBe;
import com.zippeykeys.praisebe.common.block.BlockIdol;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = PraiseBe.MODID)
public class RegisterBlocks{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<? super Block> event){
        event.getRegistry().registerAll(new Block[]{new BlockIdol()});
    }
}

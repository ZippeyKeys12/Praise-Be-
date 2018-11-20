package com.zippeykeys.praisebe.common.handler;

import java.util.Arrays;

import com.zippeykeys.praisebe.PraiseBe;
import com.zippeykeys.praisebe.common.block.BlockIdol;
import com.zippeykeys.praisebe.common.block.PBBlock;

import org.jetbrains.annotations.NotNull;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = PraiseBe.MOD_ID)
public class RegisterBlocks {
    private static final PBBlock[] blocks = new PBBlock[] { new BlockIdol() };

    @SubscribeEvent
    public static void registerBlocks(@NotNull RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(blocks);
        Arrays.stream(blocks).filter(block -> block.getTileEntity() != null)
                .forEach(block -> GameRegistry.registerTileEntity(block.getTileEntity(), block.getResource()));
    }

    @SubscribeEvent
    public static void registerItemBlocks(@NotNull RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        Arrays.stream(blocks).forEach(b -> r.register(b.getItem()));
    }
}

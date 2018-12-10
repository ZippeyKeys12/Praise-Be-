package com.zippeykeys.praisebe.common.util;

import java.util.Arrays;

import com.zippeykeys.praisebe.common.block.ModBlocks;

import org.jetbrains.annotations.NotNull;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRegistry {
    @SubscribeEvent
    public static void registerBlocks(@NotNull RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS);
        Arrays.stream(ModBlocks.BLOCKS).filter(block -> block.getTileEntity() != null)
                .forEach(block -> GameRegistry.registerTileEntity(block.getTileEntity(), block.getResource()));
    }

    @SubscribeEvent
    public static void registerItemBlocks(@NotNull RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        Arrays.stream(ModBlocks.BLOCKS).forEach(b -> r.register(new ItemBlock(b).setRegistryName(b.getRegistryName())));
    }
}
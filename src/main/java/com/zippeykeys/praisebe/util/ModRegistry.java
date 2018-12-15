package com.zippeykeys.praisebe.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import com.zippeykeys.praisebe.block.AbstractPBBlock;

import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@UtilityClass
@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRegistry {
    public static final Set<Block> BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void registerBlocks(@NotNull Register<Block> event) {
        register(event, BLOCKS);
        BLOCKS.stream().map(b -> (AbstractPBBlock) b).filter(block -> block != null && block.getTileEntity() != null)
                .forEach(block -> GameRegistry.registerTileEntity(block.getTileEntity(), block.getResource()));
    }

    @SubscribeEvent
    public static void registerItemBlocks(@NotNull Register<Item> event) {
        register(event, BlockUtil::itemFromBlock, BLOCKS);
    }

    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>> void register(
            @NotNull Register<R> e, Function<T, R> mapper, @NotNull Collection<T> values) {
        register(e, mapper, values.stream());
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>> void register(
            @NotNull Register<R> e, Function<T, R> mapper, T... values) {
        register(e, mapper, Arrays.stream(values));
    }

    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>> void register(
            @NotNull Register<R> e, Function<T, R> mapper, @NotNull Stream<T> values) {
        register(e, values.map(mapper));
    }

    @SuppressWarnings("unchecked")
    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e, @NotNull Stream<T> values) {
        e.getRegistry().registerAll((T[]) values.toArray());
    }

    @SuppressWarnings("unchecked")
    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e,
            @NotNull Collection<T> values) {
        e.getRegistry().registerAll((T[]) values.toArray());
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e, T... values) {
        e.getRegistry().registerAll(values);
    }
}
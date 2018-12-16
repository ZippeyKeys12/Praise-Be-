package com.zippeykeys.praisebe.util;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;
import com.zippeykeys.praisebe.block.ModBlocks;
import com.zippeykeys.praisebe.block.base.AbstractPBBlock;

import org.jetbrains.annotations.NotNull;

import lombok.val;
import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@UtilityClass
@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRegistry {
    public static final Set<Block> BLOCKS;

    static {
        val blocks = ImmutableSet.<Block>builder();
        Arrays.stream(ModBlocks.class.getDeclaredFields())//
                .filter(AccessibleObject::isAccessible)//
                .map(x -> (Block) ClassUtil.getFieldValue(x))//
                .filter(Objects::nonNull)//
                .forEach(blocks::add);
        BLOCKS = blocks.build();
    }

    @SubscribeEvent
    public static void registerBlocks(@NotNull Register<Block> event) {
        register(event, BLOCKS);
        BLOCKS.stream()//
                .map(b -> (AbstractPBBlock) b)//
                .filter(Objects::nonNull)//
                .map(AbstractPBBlock::getTileEntity)//
                .filter(Objects::nonNull)//
                .forEach(tilentity -> GameRegistry.registerTileEntity(tilentity, (ResourceLocation) Objects
                        .requireNonNull(ClassUtil.callDeclaredMethod(tilentity, "getResource"))));
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

    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e, @NotNull Stream<T> values) {
        val r = e.getRegistry();
        values.forEach(r::register);
    }

    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e,
            @NotNull Collection<T> values) {
        val r = e.getRegistry();
        values.forEach(r::register);
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e, T... values) {
        e.getRegistry().registerAll(values);
    }
}
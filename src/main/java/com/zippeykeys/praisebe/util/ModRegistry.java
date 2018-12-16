package com.zippeykeys.praisebe.util;

import com.google.common.collect.ImmutableSet;
import com.zippeykeys.praisebe.block.AbstractPBBlock;
import com.zippeykeys.praisebe.block.ModBlocks;
import lombok.experimental.UtilityClass;
import lombok.val;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

@UtilityClass
@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRegistry {
    public static final Set<Block> BLOCKS;

    static {
        val blocks = ImmutableSet.<Block>builder();
        Arrays.stream(ModBlocks.class.getDeclaredFields()).filter(AccessibleObject::isAccessible).forEach(f -> {
            try {
                blocks.add((AbstractPBBlock) f.get(null));
            } catch (IllegalAccessException ignored) {
            }
        });
        BLOCKS = blocks.build();
    }

    @SubscribeEvent
    public static void registerBlocks(@NotNull Register<Block> event) {
        register(event, BLOCKS);
        BLOCKS.stream().map(b -> (AbstractPBBlock) b).filter(Objects::nonNull).map(AbstractPBBlock::getTileEntity)
                .filter(Objects::nonNull).forEach(tilentity -> {
                    try {
                        GameRegistry.registerTileEntity(tilentity,
                                (ResourceLocation) tilentity.getDeclaredMethod("getResource").invoke(null));
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                            | NoSuchMethodException | SecurityException ignored) {
                    }
                });
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
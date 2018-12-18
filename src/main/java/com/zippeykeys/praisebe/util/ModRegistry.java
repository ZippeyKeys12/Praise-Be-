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
import com.zippeykeys.praisebe.block.base.PBBlock;
import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.deity.ModDeities;

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
    public static final Set<PBBlock> BLOCKS;

    public static final Set<Deity> DEITIES;

    static {
        val blocks = ImmutableSet.<PBBlock>builder();
        Arrays.stream(ModBlocks.class.getDeclaredFields()) //
                // .filter(AccessibleObject::isAccessible) //
                .map(x -> (PBBlock) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(blocks::add);
        BLOCKS = blocks.build();

        val deities = ImmutableSet.<Deity>builder();
        Arrays.stream(ClassUtil.getDeclaredFields(ModDeities.class.getDeclaredClasses())) //
                .filter(AccessibleObject::isAccessible) //
                .map(x -> (Deity) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(deities::add);
        DEITIES = deities.build();
    }

    @SubscribeEvent
    public static void registerBlocks(@NotNull Register<Block> event) {
        register(event, BLOCKS);
        BLOCKS.stream() //
                .map(PBBlock::getTileEntity) //
                .filter(Objects::nonNull) //
                .forEach(tilentity -> GameRegistry.registerTileEntity(tilentity,
                        (ResourceLocation) Objects.requireNonNull(ClassUtil.callDeclaredMethod(tilentity, "getResource",
                                ClassUtil.newInstance(tilentity)))));
    }

    @SubscribeEvent
    public static void registerItems(@NotNull Register<Item> event) {
        register(event, PBBlock::getItem, BLOCKS);
    }

    @SubscribeEvent
    public static void registerDeities(@NotNull Register<Deity> event) {
        register(event, DEITIES);
    }

    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>, K extends T> void register(
            @NotNull Register<R> e, Function<K, R> mapper, @NotNull Collection<K> values) {
        register(e, mapper, values.stream());
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>, K extends T> void register(
            @NotNull Register<R> e, Function<K, R> mapper, K... values) {
        register(e, mapper, Arrays.stream(values));
    }

    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>, K extends T> void register(
            @NotNull Register<R> e, Function<K, R> mapper, @NotNull Stream<K> values) {
        register(e, values.map(mapper));
    }

    public static <T extends IForgeRegistryEntry<T>, K extends T> void register(@NotNull Register<T> e,
            @NotNull Stream<K> values) {
        val r = e.getRegistry();
        values.forEach(r::register);
    }

    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e,
            @NotNull Collection<? extends T> values) {
        val r = e.getRegistry();
        values.forEach(r::register);
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>> void register(@NotNull Register<T> e, T... values) {
        e.getRegistry().registerAll(values);
    }
}
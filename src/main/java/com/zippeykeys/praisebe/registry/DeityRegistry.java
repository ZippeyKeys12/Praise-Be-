package com.zippeykeys.praisebe.registry;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.util.Reference;
import com.zippeykeys.praisebe.util.Util;

import org.jetbrains.annotations.NotNull;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class DeityRegistry extends PBRegistry<Deity> {
    public static final DeityRegistry INSTANCE = new DeityRegistry();

    public static IForgeRegistry<Deity> DEITIES;

    @SubscribeEvent
    public static void registerRegistries(@NotNull RegistryEvent.NewRegistry event) {
        DEITIES = new RegistryBuilder<Deity>() //
                .setName(Util.getResource("deities")) //
                .setIDRange(0, Short.MAX_VALUE) //
                .setType(Deity.class) //
                .create();
    }

    public DeityRegistry() {
        super(Deity.class, Deity.Type.class, Deity.Element.class, Deity.Alignment.class);
    }

    public Deity register(Deity value) {
        return register(Util.getResource(value.getName()), value);
    }

    public Deity[] registerAll(Deity... values) {
        return registerAll(Arrays.stream(values));
    }

    public Deity[] registerAll(Collection<? extends Deity> values) {
        return registerAll(values.stream());
    }

    public Deity[] registerAll(Stream<? extends Deity> values) {
        return values.map(this::register) //
                .filter(Objects::nonNull) //
                .toArray(Deity[]::new);
    }

    public Set<String> keySet() {
        return entries().keySet();
    }

    public Collection<Deity> values() {
        return entries().values();
    }

    public Map<String, Deity> entries() {
        return ImmutableMap.<String, Deity>builder().putAll(classes).build();
    }
}
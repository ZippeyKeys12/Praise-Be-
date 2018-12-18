package com.zippeykeys.praisebe.deity;

import com.google.common.collect.ImmutableMap;
import com.zippeykeys.praisebe.registry.PBRegistry;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;
import com.zippeykeys.praisebe.util.Util;
import lombok.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

@Builder(toBuilder = true)
public class Deity extends IForgeRegistryEntry.Impl<Deity> implements Localize {
    @Getter(onMethod_ = @Override)
    private String name;

    private Type type;

    private Element element;

    private Alignment alignment;

    @Singular
    private ImmutableMap<String, Relationship> relationships;

    public Deity(String nameIn, Type typeIn, Element elementIn, Alignment alignmentIn,
            ImmutableMap<String, Relationship> relationshipsIn) {
        name = nameIn;
        type = typeIn;
        element = elementIn;
        alignment = alignmentIn;
        relationships = relationshipsIn;
        setRegistryName(Util.getResource(nameIn));
    }

    @Override
    @Contract(pure = true)
    public @NotNull String getPrefix() {
        return "deity";
    }

    public @NotNull Relationship getRelationship(Deity deity) {
        return getRelationship(deity.getName());
    }

    public @NotNull Relationship getRelationship(String deity) {
        return relationships.get(deity);
    }

    @ToString
    @AllArgsConstructor
    public enum Type implements Localize {
        TERRESTRIAL("terrestrial"), //
        CELESTIAL("celestial"), //
        ETHEREAL("ethereal");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getPrefix() {
            return "deity.type";
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Element implements Localize {
        AIR("air"), //
        EARTH("earth"), //
        FIRE("fire"), //
        WATER("water");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getPrefix() {
            return "deity.element";
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Alignment implements Localize {
        GOOD("good"), //
        NEUTRAL("neutral"), //
        EVIL("evil");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getPrefix() {
            return "deity.alignment";
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Relationship implements Localize {
        HATED("hated"), //
        DISLIKED("disliked"), //
        INDIFFERENT("indifferent"), //
        LIKED("liked"), //
        LOVED("loved"), //
        SELF("self");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getPrefix() {
            return "deity.relationship";
        }
    }

    @EventBusSubscriber(modid = Reference.MOD_ID)
    public static class Registry extends PBRegistry<Deity> {
        public static final Registry INSTANCE = new Registry();

        public static IForgeRegistry<Deity> DEITIES;

        @SubscribeEvent
        public static void registerRegistries(@NotNull RegistryEvent.NewRegistry event) {
            DEITIES = new RegistryBuilder<Deity>() //
                    .setName(Util.getResource("deities")) //
                    .setIDRange(0, Integer.MAX_VALUE - 1) //
                    .setType(Deity.class) //
                    .create();
        }

        public Registry() {
            super(Deity.Type.class, Deity.Element.class, Deity.Alignment.class);
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
    }
}
package com.zippeykeys.praisebe.deity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.zippeykeys.praisebe.registry.PBRegistry;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;
import com.zippeykeys.praisebe.util.Util;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;
import org.immutables.value.Value.Style.ImplementationVisibility;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.val;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

@Style(visibility = ImplementationVisibility.PACKAGE, overshadowImplementation = true)

@Immutable(copy = false)
public abstract class Deity extends IForgeRegistryEntry.Impl<Deity> implements Localize {
    @Override
    public abstract @NotNull String getName();

    public abstract Type getType();

    public abstract Element getElement();

    public abstract Alignment getAlignment();

    public abstract ImmutableMap<String, Relationship> getRelationships();

    @Override
    @Contract(pure = true)
    public @NotNull String getPrefix() {
        return "deity";
    }

    public @NotNull Relationship getRelationship(Deity deity) {
        return getRelationship(deity.getName());
    }

    public @NotNull Relationship getRelationship(String deity) {
        return getRelationships().get(deity);
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

    public static class Builder extends ImmutableDeity.Builder {
        @Override
        public Deity build() {
            val result = super.build();
            result.setRegistryName(Util.getResource(result.getName()));
            return result;
        }

        public Builder relationship(String deity, Relationship relationship) {
            putRelationships(deity, relationship);
            return this;
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
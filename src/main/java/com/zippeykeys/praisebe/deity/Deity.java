package com.zippeykeys.praisebe.deity;

import com.google.common.collect.ImmutableMap;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Builder(toBuilder = true)
public class Deity extends IForgeRegistryEntry.Impl<Deity> implements Localize {
    @Getter(onMethod_ = @Override)
    private String name;

    private Type type;

    private Element element;

    private Alignment alignment;

    @Singular
    private ImmutableMap<String, Relationship> relationships;

    public Deity(String name, Type type, Element element, Alignment alignment,
            ImmutableMap<String, Relationship> relationships) {
        this.name = name;
        this.type = type;
        this.element = element;
        this.alignment = alignment;
        this.relationships = relationships;
        setRegistryName(Util.getResource(name));
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
}
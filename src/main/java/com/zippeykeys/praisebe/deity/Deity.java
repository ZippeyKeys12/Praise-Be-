package com.zippeykeys.praisebe.deity;

import com.google.common.collect.ImmutableMap;
import com.zippeykeys.praisebe.pattern.ILocalize;
import com.zippeykeys.praisebe.util.Util;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;
import org.immutables.value.Value.Style.ImplementationVisibility;
import org.jetbrains.annotations.Contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.val;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Style(visibility = ImplementationVisibility.PACKAGE, overshadowImplementation = true, depluralize = true, strictBuilder = true)

@Immutable(copy = false)
public abstract class Deity extends IForgeRegistryEntry.Impl<Deity> implements ILocalize {
    @Override
    public abstract String getName();

    public abstract Type getType();

    public abstract Element getElement();

    public abstract Alignment getAlignment();

    public abstract ImmutableMap<String, Relationship> getRelationships();

    @Override
    @Contract(pure = true)
    public String getPrefix() {
        return "deity";
    }

    public Relationship getRelationship(Deity deity) {
        return getRelationship(deity.getName());
    }

    public Relationship getRelationship(String deity) {
        return getRelationships().get(deity);
    }

    @Contract(" -> new")
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ImmutableDeity.Builder {
        @Override
        public Deity build() {
            val result = super.build();
            result.setRegistryName(Util.getResource(result.getName()));
            return result;
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Type implements ILocalize {
        TERRESTRIAL("terrestrial"), //
        CELESTIAL("celestial"), //
        ETHEREAL("ethereal");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public String getPrefix() {
            return "deity.type";
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Element implements ILocalize {
        AIR("air"), //
        EARTH("earth"), //
        FIRE("fire"), //
        WATER("water");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public String getPrefix() {
            return "deity.element";
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Alignment implements ILocalize {
        GOOD("good"), //
        NEUTRAL("neutral"), //
        EVIL("evil");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public String getPrefix() {
            return "deity.alignment";
        }
    }

    @ToString
    @AllArgsConstructor
    public enum Relationship implements ILocalize {
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
        public String getPrefix() {
            return "deity.relationship";
        }
    }
}
package com.zippeykeys.praisebe.deity;

import com.zippeykeys.praisebe.util.Localize;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public interface IDeity extends Localize {
    @NotNull
    Type getType();

    @NotNull
    Element getElement();

    @NotNull
    Alignment getAlignment();

    @NotNull
    Relationship getRelationship(IDeity other);

    @ToString
    @AllArgsConstructor
    public static enum Type implements Localize {
        TERRESTRIAL("terrestrial"), CELESTIAL("celestial"), ETHEREAL("ethereal");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getUnlocalizedName() {
            return "deity.type." + name + ".name";
        }

        @Override
        @Contract(pure = true)
        public @NotNull String getUnlocalizedDescription() {
            return "deity.type." + name + ".desc";
        }
    }

    @ToString
    @AllArgsConstructor
    public static enum Element implements Localize {
        AIR("air"), EARTH("earth"), FIRE("fire"), WATER("water");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getUnlocalizedName() {
            return "deity.element." + name + ".name";
        }

        @Override
        @Contract(pure = true)
        public @NotNull String getUnlocalizedDescription() {
            return "deity.element." + name + ".desc";
        }
    }

    @ToString
    @AllArgsConstructor
    public static enum Alignment implements Localize {
        GOOD("good"), NEUTRAL("neutral"), EVIL("evil");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        @Contract(pure = true)
        public @NotNull String getUnlocalizedName() {
            return "deity.alignment." + name + ".name";
        }

        @Override
        @Contract(pure = true)
        public @NotNull String getUnlocalizedDescription() {
            return "deity.alignment." + name + ".desc";
        }
    }

    @ToString
    @AllArgsConstructor
    public static enum Relationship implements Localize {
        HATED("hated"), DISLIKED("disliked"), INDIFFERENT("indifferent"), LIKED("liked"), LOVED("loved");

        @Getter(onMethod_ = @Override)
        private final String name;

        @Override
        public @NotNull String getUnlocalizedName() {
            return "deity.relationship." + name + ".name";
        }

        @Override
        public @NotNull String getUnlocalizedDescription() {
            return "deity.relationship." + name + ".desc";
        }
    }
}
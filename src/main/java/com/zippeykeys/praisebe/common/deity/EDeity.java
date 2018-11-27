package com.zippeykeys.praisebe.common.deity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@ToString
@AllArgsConstructor
public enum EDeity {
    ////////////////////
    ///// Celestial ////
    ////////////////////

    // Air //
    ZEUS("zeus", Type.CELESTIAL, Element.AIR, Alignment.EVIL),
    ODIN("odin", Type.CELESTIAL, Element.AIR, Alignment.GOOD),
    AMUN("amun", Type.CELESTIAL, Element.AIR, Alignment.GOOD),

    // Earth //
    TLALOC("tlaloc", Type.CELESTIAL, Element.EARTH, Alignment.NEUTRAL),
    HURACAN("huracan", Type.CELESTIAL, Element.EARTH, Alignment.NEUTRAL),

    // Fire //
    RA("ra", Type.CELESTIAL, Element.FIRE, Alignment.GOOD),
    APOLLO("apollo", Type.CELESTIAL, Element.FIRE, Alignment.NEUTRAL),
    AMATERASU("amaterasu", Type.CELESTIAL, Element.FIRE, Alignment.GOOD),

    // Water //
    WIRNPA("wirnpa", Type.CELESTIAL, Element.WATER, Alignment.NEUTRAL),
    THOR("thor", Type.CELESTIAL, Element.WATER, Alignment.GOOD),

    ////////////////////
    //// Terrestrial ///
    ////////////////////

    // Air //
    MORRIGAN("morrigan", Type.TERRESTRIAL, Element.AIR, Alignment.NEUTRAL),
    NJORD("njord", Type.TERRESTRIAL, Element.AIR, Alignment.NEUTRAL),
    TEZCCATLIPOCA("tezc", Type.TERRESTRIAL, Element.AIR, Alignment.NEUTRAL),

    // Earth //
    DAGDA("dagda", Type.TERRESTRIAL, Element.EARTH, Alignment.GOOD),
    PAN("pan", Type.TERRESTRIAL, Element.EARTH, Alignment.EVIL),
    DAGON("dagon", Type.TERRESTRIAL, Element.EARTH, Alignment.GOOD),

    // Fire //
    HEPHAESTUS("heph", Type.TERRESTRIAL, Element.FIRE, Alignment.NEUTRAL),
    GRANNUS("grannus", Type.CELESTIAL, Element.FIRE, Alignment.GOOD),
    XIUHTECUHTLI("xiuh", Type.TERRESTRIAL, Element.FIRE, Alignment.GOOD),

    // Water //
    POSEIDON("poseidon", Type.TERRESTRIAL, Element.WATER, Alignment.NEUTRAL),
    SIRONA("sirona", Type.TERRESTRIAL, Element.WATER, Alignment.GOOD),
    LOTAN("lotan", Type.TERRESTRIAL, Element.WATER, Alignment.EVIL),

    ////////////////////
    /// Otherworldly ///
    ////////////////////

    // Air //
    NYARLATHOTEP("nyar", Type.OTHERWORLDLY, Element.AIR, Alignment.EVIL),
    FUJIN("fujin", Type.OTHERWORLDLY, Element.AIR, Alignment.EVIL),
    RAIJIN("raijin", Type.OTHERWORLDLY, Element.AIR, Alignment.EVIL),

    // Earth //
    SHUB_NIGGURATH("shub", Type.OTHERWORLDLY, Element.EARTH, Alignment.NEUTRAL),
    ATUM("atum", Type.OTHERWORLDLY, Element.EARTH, Alignment.NEUTRAL),

    // Fire //
    HADES("hades", Type.OTHERWORLDLY, Element.FIRE, Alignment.EVIL),
    MOLOCH("moloch", Type.OTHERWORLDLY, Element.FIRE, Alignment.EVIL),

    // Water //
    CTHULU("cthulu", Type.OTHERWORLDLY, Element.WATER, Alignment.EVIL),
    OSIRIS("osiris", Type.OTHERWORLDLY, Element.WATER, Alignment.NEUTRAL);

    public static final EDeity[] DEITIES = values();

    @Getter
    private String name;

    @Getter
    private Type type;

    @Getter
    private Element element;

    @Getter
    private Alignment alignment;

    @Contract(pure = true)
    public @NotNull String getUnlocalizedName() {
        return "deity." + name + ".name";
    }

    @Contract(pure = true)
    public @NotNull String getUnlocalizedDescription() {
        return "deity." + name + ".desc";
    }

    public int getIndex() {
        return Arrays.asList(DEITIES).indexOf(this);
    }

    @Contract(pure = true)
    public EDeity byIndex(int index) {
        return DEITIES[index];
    }

    @ToString
    @AllArgsConstructor
    private enum Type {
        TERRESTRIAL("terrestrial"), CELESTIAL("celestial"), OTHERWORLDLY("otherworldly");

        private static final List<Type> INDICES = Arrays.asList(values());

        @Getter
        private String name;

        @Contract(pure = true)
        public @NotNull String getUnlocalizedName() {
            return "deity.type." + name + ".name";
        }

        @Contract(pure = true)
        public @NotNull String getUnlocalizedDescription() {
            return "deity.type." + name + ".desc";
        }

        public int getIndex() {
            return INDICES.indexOf(this);
        }

        @Contract(pure = true)
        public Type byIndex(int index) {
            return INDICES.get(index);
        }

    }

    @ToString
    @AllArgsConstructor
    private enum Element {
        AIR("air"), EARTH("earth"), FIRE("fire"), WATER("water");

        private static final List<Element> INDICES = Arrays.asList(values());

        @Getter
        private String name;

        @Contract(pure = true)
        public @NotNull String getUnlocalizedName() {
            return "deity.element." + name + ".name";
        }

        @Contract(pure = true)
        public @NotNull String getUnlocalizedDescription() {
            return "deity.element." + name + ".desc";
        }

        public int getIndex() {
            return INDICES.indexOf(this);
        }

        @Contract(pure = true)
        public Element byIndex(int index) {
            return INDICES.get(index);
        }
    }

    @ToString
    @AllArgsConstructor
    private enum Alignment {
        GOOD("good"), NEUTRAL("neutral"), EVIL("evil");

        private static final List<Alignment> INDICES = Arrays.asList(values());

        @Getter
        private String name;

        @Contract(pure = true)
        public @NotNull String getUnlocalizedName() {
            return "deity.alignment." + name + ".name";
        }

        @Contract(pure = true)
        public @NotNull String getUnlocalizedDescription() {
            return "deity.alignment." + name + ".desc";
        }

        public int getIndex() {
            return INDICES.indexOf(this);
        }

        @Contract(pure = true)
        public Alignment byIndex(int index) {
            return INDICES.get(index);
        }
    }
}
package com.zippeykeys.praisebe.common.deity;

import com.zippeykeys.praisebe.common.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
    HURACAN("huracan", Type.CELESTIAL, Element.EARTH, Alignment.EVIL),
    DEMETER("demeter", Type.CELESTIAL, Element.EARTH, Alignment.EVIL),

    // Fire //
    RA("ra", Type.CELESTIAL, Element.FIRE, Alignment.GOOD),
    APOLLO("apollo", Type.CELESTIAL, Element.FIRE, Alignment.NEUTRAL),
    AMATERASU("amaterasu", Type.CELESTIAL, Element.FIRE, Alignment.GOOD),

    // Water //
    WIRNPA("wirnpa", Type.CELESTIAL, Element.WATER, Alignment.NEUTRAL),
    THOR("thor", Type.CELESTIAL, Element.WATER, Alignment.GOOD),
    BAAL("baal", Type.CELESTIAL, Element.WATER, Alignment.GOOD),

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
    /// Ethereal ///
    ////////////////////

    // Air //
    NYARLATHOTEP("nyar", Type.ETHEREAL, Element.AIR, Alignment.EVIL),
    FUJIN("fujin", Type.ETHEREAL, Element.AIR, Alignment.EVIL),
    RAIJIN("raijin", Type.ETHEREAL, Element.AIR, Alignment.EVIL),

    // Earth //
    SHUB_NIGGURATH("shub", Type.ETHEREAL, Element.EARTH, Alignment.NEUTRAL),
    ATUM("atum", Type.ETHEREAL, Element.EARTH, Alignment.NEUTRAL),
    ANUBIS("anubis", Type.ETHEREAL, Element.EARTH, Alignment.EVIL),

    // Fire //
    HADES("hades", Type.ETHEREAL, Element.FIRE, Alignment.EVIL),
    MOLOCH("moloch", Type.ETHEREAL, Element.FIRE, Alignment.EVIL),
    PEKELNYBOG("pekelnybog", Type.ETHEREAL, Element.FIRE, Alignment.NEUTRAL),

    // Water //
    CTHULU("cthulu", Type.ETHEREAL, Element.WATER, Alignment.EVIL),
    OSIRIS("osiris", Type.ETHEREAL, Element.WATER, Alignment.NEUTRAL),
    CHARON("charon", Type.ETHEREAL, Element.WATER, Alignment.GOOD);

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

    public int getMeta() {
        return EnumUtil.getUniqueIndex(type, element, alignment);
    }

    @ToString
    @AllArgsConstructor
    private enum Type {
        TERRESTRIAL("terrestrial"), CELESTIAL("celestial"), ETHEREAL("ethereal");

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

    }

    @ToString
    @AllArgsConstructor
    private enum Element {
        AIR("air"), EARTH("earth"), FIRE("fire"), WATER("water");

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
    }

    @ToString
    @AllArgsConstructor
    private enum Alignment {
        GOOD("good"), NEUTRAL("neutral"), EVIL("evil");

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
    }
}
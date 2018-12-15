package com.zippeykeys.praisebe.deity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum EDeity implements IDeity {
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

    @Getter(onMethod_ = @Override)
    private String name;

    @Getter(onMethod_ = @Override)
    private Type type;

    @Getter(onMethod_ = @Override)
    private Element element;

    @Getter(onMethod_ = @Override)
    private Alignment alignment;

    @Override
    @Contract(pure = true)
    public @NotNull String getUnlocalizedName() {
        return "deity." + name + ".name";
    }

    @Override
    @Contract(pure = true)
    public @NotNull String getUnlocalizedDescription() {
        return "deity." + name + ".desc";
    }
}
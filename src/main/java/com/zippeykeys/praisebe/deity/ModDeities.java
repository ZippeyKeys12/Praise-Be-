package com.zippeykeys.praisebe.deity;

import static com.zippeykeys.praisebe.deity.IDeity.Alignment.EVIL;
import static com.zippeykeys.praisebe.deity.IDeity.Alignment.GOOD;
import static com.zippeykeys.praisebe.deity.IDeity.Alignment.NEUTRAL;
import static com.zippeykeys.praisebe.deity.IDeity.Element.AIR;
import static com.zippeykeys.praisebe.deity.IDeity.Element.EARTH;
import static com.zippeykeys.praisebe.deity.IDeity.Element.FIRE;
import static com.zippeykeys.praisebe.deity.IDeity.Element.WATER;
import static com.zippeykeys.praisebe.deity.IDeity.Relationship.DISLIKED;
import static com.zippeykeys.praisebe.deity.IDeity.Relationship.HATED;
import static com.zippeykeys.praisebe.deity.IDeity.Relationship.INDIFFERENT;
import static com.zippeykeys.praisebe.deity.IDeity.Relationship.LIKED;
import static com.zippeykeys.praisebe.deity.IDeity.Relationship.LOVED;
import static com.zippeykeys.praisebe.deity.IDeity.Type.CELESTIAL;
import static com.zippeykeys.praisebe.deity.IDeity.Type.ETHEREAL;
import static com.zippeykeys.praisebe.deity.IDeity.Type.TERRESTRIAL;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ModDeities {
    public static class Celestial {
        // Air //
        public static final IDeity ZEUS = IDeityImpl.builder() //
                .name("zeus") //
                .type(CELESTIAL) //
                .element(AIR) //
                .alignment(EVIL) //
                .relationship("odin", HATED) //
                .relationship("amun", LIKED) //
                .relationship("tlaloc", INDIFFERENT) //
                .relationship("huracan", LIKED) //
                .relationship("demeter", LOVED) //
                .relationship("ra", INDIFFERENT) //
                .relationship("apollo", LIKED) //
                .relationship("amaterasu", LOVED) //
                .relationship("wirnpa", INDIFFERENT) //
                .relationship("thor", DISLIKED) //
                .relationship("baal", INDIFFERENT) //
                .build(); //

        public static final IDeity ODIN = IDeityImpl.builder() //
                .name("odin") //
                .type(CELESTIAL) //
                .element(AIR) //
                .alignment(GOOD) //
                .relationship("zeus", HATED) //
                .relationship("amun", INDIFFERENT) //
                .relationship("tlaloc", LIKED) //
                .relationship("huracan", DISLIKED) //
                .relationship("demeter", INDIFFERENT) //
                .relationship("ra", LIKED) //
                .relationship("apollo", DISLIKED) //
                .relationship("amaterasu", LOVED) //
                .relationship("wirnpa", INDIFFERENT) //
                .relationship("thor", LOVED) //
                .relationship("baal", DISLIKED) //
                .build(); //

        public static final IDeity AMUN = IDeityImpl.builder() //
                .name("amun") //
                .type(CELESTIAL) //
                .element(AIR) //
                .alignment(GOOD) //
                .relationship("zeus", LIKED) //
                .relationship("odin", INDIFFERENT) //
                .relationship("tlaloc", DISLIKED) //
                .relationship("huracan", INDIFFERENT) //
                .relationship("demeter", INDIFFERENT) //
                .relationship("ra", LIKED) //
                .relationship("apollo", LIKED) //
                .relationship("amaterasu", INDIFFERENT) //
                .relationship("wirnpa", LIKED) //
                .relationship("thor", DISLIKED) //
                .relationship("baal", DISLIKED) //
                .build(); //

        // Earth //
        public static final IDeity TLALOC = IDeityImpl.builder() //
                .name("tlaloc") //
                .type(CELESTIAL) //
                .element(EARTH) //
                .alignment(NEUTRAL) //
                .relationship("zeus", INDIFFERENT) //
                .relationship("odin", LIKED) //
                .relationship("amun", LIKED) //
                .relationship("huracan", INDIFFERENT) //
                .relationship("demeter", LIKED) //
                .relationship("ra", DISLIKED) //
                .relationship("apollo", LIKED) //
                .relationship("amaterasu", DISLIKED) //
                .relationship("wirnpa", DISLIKED) //
                .relationship("thor", HATED) //
                .relationship("baal", INDIFFERENT) //
                .build(); //

        public static final IDeity HURACAN = IDeityImpl.builder() //
                .name("huracan") //
                .type(CELESTIAL) //
                .element(EARTH) //
                .alignment(EVIL) //
                .relationship("zeus", DISLIKED) //
                .relationship("odin", INDIFFERENT) //
                .relationship("amun", HATED) //
                .relationship("tlaloc", LIKED) //
                .relationship("demeter", LIKED) //
                .relationship("ra", HATED) //
                .relationship("apollo", INDIFFERENT) //
                .relationship("amaterasu", LIKED) //
                .relationship("wirnpa", LIKED) //
                .relationship("thor", LIKED) //
                .relationship("baal", LOVED) //
                .build(); //

        public static final IDeity DEMETER = IDeityImpl.builder() //
                .name("demeter") //
                .type(CELESTIAL) //
                .element(EARTH) //
                .alignment(GOOD) //
                .relationship("zeus", LOVED) //
                .relationship("odin", LOVED) //
                .relationship("amun", DISLIKED) //
                .relationship("tlaloc", HATED) //
                .relationship("huracan", INDIFFERENT) //
                .relationship("ra", LIKED) //
                .relationship("apollo", LOVED) //
                .relationship("amaterasu", HATED) //
                .relationship("wirnpa", LIKED) //
                .relationship("thor", HATED) //
                .relationship("baal", INDIFFERENT) //
                .build(); //

        // Fire //
        public static final IDeity RA = IDeityImpl.builder() //
                .name("ra") //
                .type(CELESTIAL) //
                .element(FIRE) //
                .alignment(GOOD) //
                .relationship("zeus", DISLIKED) //
                .relationship("odin", LIKED) //
                .relationship("amun", LOVED) //
                .relationship("tlaloc", DISLIKED) //
                .relationship("huracan", HATED) //
                .relationship("demeter", LIKED) //
                .relationship("apollo", LIKED) //
                .relationship("amaterasu", LIKED) //
                .relationship("wirnpa", INDIFFERENT) //
                .relationship("thor", INDIFFERENT) //
                .relationship("baal", DISLIKED) //
                .build(); //

        public static final IDeity APOLLO = IDeityImpl.builder() //
                .name("apollo") //
                .type(CELESTIAL) //
                .element(FIRE) //
                .alignment(NEUTRAL) //
                .relationship("zeus", LOVED) //
                .relationship("odin", HATED) //
                .relationship("amun", LIKED) //
                .relationship("tlaloc", INDIFFERENT) //
                .relationship("huracan", DISLIKED) //
                .relationship("demeter", DISLIKED) //
                .relationship("ra", LIKED) //
                .relationship("amaterasu", LIKED) //
                .relationship("wirnpa", LIKED) //
                .relationship("thor", HATED) //
                .relationship("baal", INDIFFERENT) //
                .build(); //

        public static final IDeity AMATERASU = IDeityImpl.builder() //
                .name("amaterasu") //
                .type(CELESTIAL) //
                .element(FIRE) //
                .alignment(GOOD) //
                .relationship("zeus", HATED) //
                .relationship("odin", LIKED) //
                .relationship("amun", LIKED) //
                .relationship("tlaloc", DISLIKED) //
                .relationship("huracan", HATED) //
                .relationship("demeter", HATED) //
                .relationship("ra", LOVED) //
                .relationship("apollo", DISLIKED) //
                .relationship("wirnpa", DISLIKED) //
                .relationship("thor", LIKED) //
                .relationship("baal", HATED) //
                .build(); //

        // Water //
        public static final IDeity WIRNPA = IDeityImpl.builder() //
                .name("wirnpa") //
                .type(CELESTIAL) //
                .element(WATER) //
                .alignment(NEUTRAL) //
                .relationship("zeus", DISLIKED) //
                .relationship("odin", DISLIKED) //
                .relationship("amun", LIKED) //
                .relationship("tlaloc", DISLIKED) //
                .relationship("huracan", DISLIKED) //
                .relationship("demeter", INDIFFERENT) //
                .relationship("ra", LIKED) //
                .relationship("apollo", DISLIKED) //
                .relationship("amaterasu", INDIFFERENT) //
                .relationship("thor", LIKED) //
                .relationship("baal", LIKED) //
                .build(); //

        public static final IDeity THOR = IDeityImpl.builder() //
                .name("thor") //
                .type(CELESTIAL) //
                .element(WATER) //
                .alignment(GOOD) //
                .relationship("zeus", HATED) //
                .relationship("odin", LOVED) //
                .relationship("amun", DISLIKED) //
                .relationship("tlaloc", HATED) //
                .relationship("huracan", DISLIKED) //
                .relationship("demeter", DISLIKED) //
                .relationship("ra", LIKED) //
                .relationship("apollo", HATED) //
                .relationship("amaterasu", LOVED) //
                .relationship("wirnpa", LIKED) //
                .relationship("baal", DISLIKED) //
                .build(); //

        public static final IDeity BAAL = IDeityImpl.builder() //
                .name("baal") //
                .type(CELESTIAL) //
                .element(WATER) //
                .alignment(EVIL) //
                .relationship("zeus", INDIFFERENT) //
                .relationship("odin", INDIFFERENT) //
                .relationship("amun", LIKED) //
                .relationship("tlaloc", DISLIKED) //
                .relationship("huracan", LIKED) //
                .relationship("demeter", INDIFFERENT) //
                .relationship("ra", HATED) //
                .relationship("apollo", DISLIKED) //
                .relationship("amaterasu", HATED) //
                .relationship("wirnpa", LIKED) //
                .relationship("thor", DISLIKED) //
                .build(); //
    }

    public static class Terrestrial {
        // Air //
        public static final IDeity MORRIGAN = IDeityImpl.builder() //
                .name("morrigan") //
                .type(TERRESTRIAL) //
                .element(AIR) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity NJORD = IDeityImpl.builder() //
                .name("njord") //
                .type(TERRESTRIAL) //
                .element(AIR) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity TEZCCATLIPOCA = IDeityImpl.builder() //
                .name("tezc") //
                .type(TERRESTRIAL) //
                .element(AIR) //
                .alignment(NEUTRAL) //
                .build(); //

        // Earth //
        public static final IDeity DAGDA = IDeityImpl.builder() //
                .name("dagda") //
                .type(TERRESTRIAL) //
                .element(EARTH) //
                .alignment(GOOD) //
                .build(); //

        public static final IDeity PAN = IDeityImpl.builder() //
                .name("pan") //
                .type(TERRESTRIAL) //
                .element(EARTH) //
                .alignment(EVIL) //
                .build(); //

        public static final IDeity DAGON = IDeityImpl.builder() //
                .name("dagon") //
                .type(TERRESTRIAL) //
                .element(EARTH) //
                .alignment(GOOD) //
                .build(); //

        // Fire //
        public static final IDeity HEPHAESTUS = IDeityImpl.builder() //
                .name("heph") //
                .type(TERRESTRIAL) //
                .element(FIRE) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity GRANNUS = IDeityImpl.builder() //
                .name("grannus") //
                .type(TERRESTRIAL) //
                .element(FIRE) //
                .alignment(GOOD) //
                .build(); //

        public static final IDeity XIUHTECUHTLI = IDeityImpl.builder() //
                .name("xiuh") //
                .type(TERRESTRIAL) //
                .element(FIRE) //
                .alignment(GOOD) //
                .build(); //

        // Water //
        public static final IDeity POSEIDON = IDeityImpl.builder() //
                .name("poseidon") //
                .type(TERRESTRIAL) //
                .element(WATER) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity SIRONA = IDeityImpl.builder() //
                .name("sirona") //
                .type(TERRESTRIAL) //
                .element(WATER) //
                .alignment(GOOD) //
                .build(); //

        public static final IDeity LOTAN = IDeityImpl.builder() //
                .name("lotan") //
                .type(TERRESTRIAL) //
                .element(WATER) //
                .alignment(EVIL) //
                .build(); //
    }

    public static class Ethereal {
        // Air //
        public static final IDeity NYARLATHOTEP = IDeityImpl.builder() //
                .name("nyar") //
                .type(ETHEREAL) //
                .element(AIR) //
                .alignment(EVIL) //
                .build(); //

        public static final IDeity FUJIN = IDeityImpl.builder() //
                .name("fujin") //
                .type(ETHEREAL) //
                .element(AIR) //
                .alignment(EVIL) //
                .build(); //

        public static final IDeity RAIJIN = IDeityImpl.builder() //
                .name("raijin") //
                .type(ETHEREAL) //
                .element(AIR) //
                .alignment(EVIL) //
                .build(); //

        // Earth //
        public static final IDeity SHUB_NIGGURATH = IDeityImpl.builder() //
                .name("shub") //
                .type(ETHEREAL) //
                .element(EARTH) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity ATUM = IDeityImpl.builder() //
                .name("atum") //
                .type(ETHEREAL) //
                .element(EARTH) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity ANUBIS = IDeityImpl.builder() //
                .name("anubis") //
                .type(ETHEREAL) //
                .element(EARTH) //
                .alignment(EVIL) //
                .build(); //

        // Fire //
        public static final IDeity HADES = IDeityImpl.builder() //
                .name("hades") //
                .type(ETHEREAL) //
                .element(FIRE) //
                .alignment(EVIL) //
                .build(); //

        public static final IDeity MOLOCH = IDeityImpl.builder() //
                .name("moloch") //
                .type(ETHEREAL) //
                .element(FIRE) //
                .alignment(EVIL) //
                .build(); //

        public static final IDeity PEKELNYBOG = IDeityImpl.builder() //
                .name("pekel") //
                .type(ETHEREAL) //
                .element(FIRE) //
                .alignment(NEUTRAL) //
                .build(); //

        // Water //
        public static final IDeity CTHULU = IDeityImpl.builder() //
                .name("cthulu") //
                .type(ETHEREAL) //
                .element(WATER) //
                .alignment(EVIL) //
                .build(); //

        public static final IDeity OSIRIS = IDeityImpl.builder() //
                .name("osiris") //
                .type(ETHEREAL) //
                .element(WATER) //
                .alignment(NEUTRAL) //
                .build(); //

        public static final IDeity CHARON = IDeityImpl.builder() //
                .name("charon") //
                .type(ETHEREAL) //
                .element(WATER) //
                .alignment(GOOD) //
                .build(); //
    }
}
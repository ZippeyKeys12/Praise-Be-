package com.zippeykeys.praisebe.deity;

import static com.zippeykeys.praisebe.deity.Deity.Alignment.EVIL;
import static com.zippeykeys.praisebe.deity.Deity.Alignment.GOOD;
import static com.zippeykeys.praisebe.deity.Deity.Alignment.NEUTRAL;
import static com.zippeykeys.praisebe.deity.Deity.Element.AIR;
import static com.zippeykeys.praisebe.deity.Deity.Element.EARTH;
import static com.zippeykeys.praisebe.deity.Deity.Element.FIRE;
import static com.zippeykeys.praisebe.deity.Deity.Element.WATER;
import static com.zippeykeys.praisebe.deity.Deity.Relationship.DISLIKED;
import static com.zippeykeys.praisebe.deity.Deity.Relationship.HATED;
import static com.zippeykeys.praisebe.deity.Deity.Relationship.INDIFFERENT;
import static com.zippeykeys.praisebe.deity.Deity.Relationship.LIKED;
import static com.zippeykeys.praisebe.deity.Deity.Relationship.LOVED;
import static com.zippeykeys.praisebe.deity.Deity.Relationship.SELF;
import static com.zippeykeys.praisebe.deity.Deity.Type.CELESTIAL;
import static com.zippeykeys.praisebe.deity.Deity.Type.ETHEREAL;
import static com.zippeykeys.praisebe.deity.Deity.Type.TERRESTRIAL;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ModDeities {
        @UtilityClass
        public static class Celestial {
                // Air //
                public static final Deity ZEUS = new Deity.Builder() //
                                .name("zeus") //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .relationship("zeus", SELF) //
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

                public static final Deity ODIN = new Deity.Builder() //
                                .name("odin") //
                                .type(CELESTIAL) //
                                .element(AIR) //
                                .alignment(GOOD) //
                                .relationship("zeus", HATED) //
                                .relationship("odin", SELF) //
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

                public static final Deity AMUN = new Deity.Builder() //
                                .name("amun") //
                                .type(CELESTIAL) //
                                .element(AIR) //
                                .alignment(GOOD) //
                                .relationship("zeus", LIKED) //
                                .relationship("odin", INDIFFERENT) //
                                .relationship("amun", SELF) //
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
                public static final Deity TLALOC = new Deity.Builder() //
                                .name("tlaloc") //
                                .type(CELESTIAL) //
                                .element(EARTH) //
                                .alignment(NEUTRAL) //
                                .relationship("zeus", INDIFFERENT) //
                                .relationship("odin", LIKED) //
                                .relationship("amun", LIKED) //
                                .relationship("tlaloc", SELF) //
                                .relationship("huracan", INDIFFERENT) //
                                .relationship("demeter", LIKED) //
                                .relationship("ra", DISLIKED) //
                                .relationship("apollo", LIKED) //
                                .relationship("amaterasu", DISLIKED) //
                                .relationship("wirnpa", DISLIKED) //
                                .relationship("thor", HATED) //
                                .relationship("baal", INDIFFERENT) //
                                .build(); //

                public static final Deity HURACAN = new Deity.Builder() //
                                .name("huracan") //
                                .type(CELESTIAL) //
                                .element(EARTH) //
                                .alignment(EVIL) //
                                .relationship("zeus", DISLIKED) //
                                .relationship("odin", INDIFFERENT) //
                                .relationship("amun", HATED) //
                                .relationship("tlaloc", LIKED) //
                                .relationship("huracan", SELF) //
                                .relationship("demeter", LIKED) //
                                .relationship("ra", HATED) //
                                .relationship("apollo", INDIFFERENT) //
                                .relationship("amaterasu", LIKED) //
                                .relationship("wirnpa", LIKED) //
                                .relationship("thor", LIKED) //
                                .relationship("baal", LOVED) //
                                .build(); //

                public static final Deity DEMETER = new Deity.Builder() //
                                .name("demeter") //
                                .type(CELESTIAL) //
                                .element(EARTH) //
                                .alignment(GOOD) //
                                .relationship("zeus", LOVED) //
                                .relationship("odin", LOVED) //
                                .relationship("amun", DISLIKED) //
                                .relationship("tlaloc", HATED) //
                                .relationship("huracan", INDIFFERENT) //
                                .relationship("demeter", SELF) //
                                .relationship("ra", LIKED) //
                                .relationship("apollo", LOVED) //
                                .relationship("amaterasu", HATED) //
                                .relationship("wirnpa", LIKED) //
                                .relationship("thor", HATED) //
                                .relationship("baal", INDIFFERENT) //
                                .build(); //

                // Fire //
                public static final Deity RA = new Deity.Builder() //
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
                                .relationship("ra", SELF) //
                                .relationship("apollo", LIKED) //
                                .relationship("amaterasu", LIKED) //
                                .relationship("wirnpa", INDIFFERENT) //
                                .relationship("thor", INDIFFERENT) //
                                .relationship("baal", DISLIKED) //
                                .build(); //

                public static final Deity APOLLO = new Deity.Builder() //
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
                                .relationship("apollo", SELF) //
                                .relationship("amaterasu", LIKED) //
                                .relationship("wirnpa", LIKED) //
                                .relationship("thor", HATED) //
                                .relationship("baal", INDIFFERENT) //
                                .build(); //

                public static final Deity AMATERASU = new Deity.Builder() //
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
                                .relationship("amaterasu", SELF) //
                                .relationship("wirnpa", DISLIKED) //
                                .relationship("thor", LIKED) //
                                .relationship("baal", HATED) //
                                .build(); //

                // Water //
                public static final Deity WIRNPA = new Deity.Builder() //
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
                                .relationship("wirnpa", SELF) //
                                .relationship("thor", LIKED) //
                                .relationship("baal", LIKED) //
                                .build(); //

                public static final Deity THOR = new Deity.Builder() //
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
                                .relationship("thor", SELF) //
                                .relationship("baal", DISLIKED) //
                                .build(); //

                public static final Deity BAAL = new Deity.Builder() //
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
                                .relationship("baal", SELF) //
                                .build(); //
        }

        @UtilityClass
        public static class Terrestrial {
                // Air //
                public static final Deity MORRIGAN = new Deity.Builder() //
                                .name("morrigan") //
                                .type(TERRESTRIAL) //
                                .element(AIR) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity NJORD = new Deity.Builder() //
                                .name("njord") //
                                .type(TERRESTRIAL) //
                                .element(AIR) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity TEZCCATLIPOCA = new Deity.Builder() //
                                .name("tezc") //
                                .type(TERRESTRIAL) //
                                .element(AIR) //
                                .alignment(NEUTRAL) //
                                .build(); //

                // Earth //
                public static final Deity DAGDA = new Deity.Builder() //
                                .name("dagda") //
                                .type(TERRESTRIAL) //
                                .element(EARTH) //
                                .alignment(GOOD) //
                                .build(); //

                public static final Deity PAN = new Deity.Builder() //
                                .name("pan") //
                                .type(TERRESTRIAL) //
                                .element(EARTH) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity DAGON = new Deity.Builder() //
                                .name("dagon") //
                                .type(TERRESTRIAL) //
                                .element(EARTH) //
                                .alignment(GOOD) //
                                .build(); //

                // Fire //
                public static final Deity HEPHAESTUS = new Deity.Builder() //
                                .name("heph") //
                                .type(TERRESTRIAL) //
                                .element(FIRE) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity GRANNUS = new Deity.Builder() //
                                .name("grannus") //
                                .type(TERRESTRIAL) //
                                .element(FIRE) //
                                .alignment(GOOD) //
                                .build(); //

                public static final Deity XIUHTECUHTLI = new Deity.Builder() //
                                .name("xiuh") //
                                .type(TERRESTRIAL) //
                                .element(FIRE) //
                                .alignment(GOOD) //
                                .build(); //

                // Water //
                public static final Deity POSEIDON = new Deity.Builder() //
                                .name("poseidon") //
                                .type(TERRESTRIAL) //
                                .element(WATER) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity SIRONA = new Deity.Builder() //
                                .name("sirona") //
                                .type(TERRESTRIAL) //
                                .element(WATER) //
                                .alignment(GOOD) //
                                .build(); //

                public static final Deity LOTAN = new Deity.Builder() //
                                .name("lotan") //
                                .type(TERRESTRIAL) //
                                .element(WATER) //
                                .alignment(EVIL) //
                                .build(); //
        }

        @UtilityClass
        public static class Ethereal {
                // Air //
                public static final Deity NYARLATHOTEP = new Deity.Builder() //
                                .name("nyar") //
                                .type(ETHEREAL) //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity FUJIN = new Deity.Builder() //
                                .name("fujin") //
                                .type(ETHEREAL) //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity RAIJIN = new Deity.Builder() //
                                .name("raijin") //
                                .type(ETHEREAL) //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .build(); //

                // Earth //
                public static final Deity SHUB_NIGGURATH = new Deity.Builder() //
                                .name("shub") //
                                .type(ETHEREAL) //
                                .element(EARTH) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity ATUM = new Deity.Builder() //
                                .name("atum") //
                                .type(ETHEREAL) //
                                .element(EARTH) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity ANUBIS = new Deity.Builder() //
                                .name("anubis") //
                                .type(ETHEREAL) //
                                .element(EARTH) //
                                .alignment(EVIL) //
                                .build(); //

                // Fire //
                public static final Deity HADES = new Deity.Builder() //
                                .name("hades") //
                                .type(ETHEREAL) //
                                .element(FIRE) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity MOLOCH = new Deity.Builder() //
                                .name("moloch") //
                                .type(ETHEREAL) //
                                .element(FIRE) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity PEKELNYBOG = new Deity.Builder() //
                                .name("pekel") //
                                .type(ETHEREAL) //
                                .element(FIRE) //
                                .alignment(NEUTRAL) //
                                .build(); //

                // Water //
                public static final Deity CTHULU = new Deity.Builder() //
                                .name("cthulu") //
                                .type(ETHEREAL) //
                                .element(WATER) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity OSIRIS = new Deity.Builder() //
                                .name("osiris") //
                                .type(ETHEREAL) //
                                .element(WATER) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity CHARON = new Deity.Builder() //
                                .name("charon") //
                                .type(ETHEREAL) //
                                .element(WATER) //
                                .alignment(GOOD) //
                                .build(); //
        }
}
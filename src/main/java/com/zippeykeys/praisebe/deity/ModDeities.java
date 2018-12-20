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
                public static final Deity ZEUS = Deity.builder() //
                                .name("zeus") //
                                .type(CELESTIAL) //
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

                public static final Deity ODIN = Deity.builder() //
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

                public static final Deity AMUN = Deity.builder() //
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
                public static final Deity TLALOC = Deity.builder() //
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

                public static final Deity HURACAN = Deity.builder() //
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

                public static final Deity DEMETER = Deity.builder() //
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
                public static final Deity RA = Deity.builder() //
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

                public static final Deity APOLLO = Deity.builder() //
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

                public static final Deity AMATERASU = Deity.builder() //
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
                public static final Deity WIRNPA = Deity.builder() //
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

                public static final Deity THOR = Deity.builder() //
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

                public static final Deity BAAL = Deity.builder() //
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
                public static final Deity MORRIGAN = Deity.builder() //
                                .name("morrigan") //
                                .type(TERRESTRIAL) //
                                .element(AIR) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity NJORD = Deity.builder() //
                                .name("njord") //
                                .type(TERRESTRIAL) //
                                .element(AIR) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity TEZCCATLIPOCA = Deity.builder() //
                                .name("tezc") //
                                .type(TERRESTRIAL) //
                                .element(AIR) //
                                .alignment(NEUTRAL) //
                                .build(); //

                // Earth //
                public static final Deity DAGDA = Deity.builder() //
                                .name("dagda") //
                                .type(TERRESTRIAL) //
                                .element(EARTH) //
                                .alignment(GOOD) //
                                .build(); //

                public static final Deity PAN = Deity.builder() //
                                .name("pan") //
                                .type(TERRESTRIAL) //
                                .element(EARTH) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity DAGON = Deity.builder() //
                                .name("dagon") //
                                .type(TERRESTRIAL) //
                                .element(EARTH) //
                                .alignment(GOOD) //
                                .build(); //

                // Fire //
                public static final Deity HEPHAESTUS = Deity.builder() //
                                .name("heph") //
                                .type(TERRESTRIAL) //
                                .element(FIRE) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity GRANNUS = Deity.builder() //
                                .name("grannus") //
                                .type(TERRESTRIAL) //
                                .element(FIRE) //
                                .alignment(GOOD) //
                                .build(); //

                public static final Deity XIUHTECUHTLI = Deity.builder() //
                                .name("xiuh") //
                                .type(TERRESTRIAL) //
                                .element(FIRE) //
                                .alignment(GOOD) //
                                .build(); //

                // Water //
                public static final Deity POSEIDON = Deity.builder() //
                                .name("poseidon") //
                                .type(TERRESTRIAL) //
                                .element(WATER) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity SIRONA = Deity.builder() //
                                .name("sirona") //
                                .type(TERRESTRIAL) //
                                .element(WATER) //
                                .alignment(GOOD) //
                                .build(); //

                public static final Deity LOTAN = Deity.builder() //
                                .name("lotan") //
                                .type(TERRESTRIAL) //
                                .element(WATER) //
                                .alignment(EVIL) //
                                .build(); //
        }

        @UtilityClass
        public static class Ethereal {
                // Air //
                public static final Deity NYARLATHOTEP = Deity.builder() //
                                .name("nyar") //
                                .type(ETHEREAL) //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity FUJIN = Deity.builder() //
                                .name("fujin") //
                                .type(ETHEREAL) //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity RAIJIN = Deity.builder() //
                                .name("raijin") //
                                .type(ETHEREAL) //
                                .element(AIR) //
                                .alignment(EVIL) //
                                .build(); //

                // Earth //
                public static final Deity SHUB_NIGGURATH = Deity.builder() //
                                .name("shub") //
                                .type(ETHEREAL) //
                                .element(EARTH) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity ATUM = Deity.builder() //
                                .name("atum") //
                                .type(ETHEREAL) //
                                .element(EARTH) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity ANUBIS = Deity.builder() //
                                .name("anubis") //
                                .type(ETHEREAL) //
                                .element(EARTH) //
                                .alignment(EVIL) //
                                .build(); //

                // Fire //
                public static final Deity HADES = Deity.builder() //
                                .name("hades") //
                                .type(ETHEREAL) //
                                .element(FIRE) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity MOLOCH = Deity.builder() //
                                .name("moloch") //
                                .type(ETHEREAL) //
                                .element(FIRE) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity PEKELNYBOG = Deity.builder() //
                                .name("pekel") //
                                .type(ETHEREAL) //
                                .element(FIRE) //
                                .alignment(NEUTRAL) //
                                .build(); //

                // Water //
                public static final Deity CTHULU = Deity.builder() //
                                .name("cthulu") //
                                .type(ETHEREAL) //
                                .element(WATER) //
                                .alignment(EVIL) //
                                .build(); //

                public static final Deity OSIRIS = Deity.builder() //
                                .name("osiris") //
                                .type(ETHEREAL) //
                                .element(WATER) //
                                .alignment(NEUTRAL) //
                                .build(); //

                public static final Deity CHARON = Deity.builder() //
                                .name("charon") //
                                .type(ETHEREAL) //
                                .element(WATER) //
                                .alignment(GOOD) //
                                .build(); //
        }
}
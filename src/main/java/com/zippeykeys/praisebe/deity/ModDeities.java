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
                                .putRelationship("zeus", SELF) //
                                .putRelationship("odin", HATED) //
                                .putRelationship("amun", LIKED) //
                                .putRelationship("tlaloc", INDIFFERENT) //
                                .putRelationship("huracan", LIKED) //
                                .putRelationship("demeter", LOVED) //
                                .putRelationship("ra", INDIFFERENT) //
                                .putRelationship("apollo", LIKED) //
                                .putRelationship("amaterasu", LOVED) //
                                .putRelationship("wirnpa", INDIFFERENT) //
                                .putRelationship("thor", DISLIKED) //
                                .putRelationship("baal", INDIFFERENT) //
                                .build(); //

                public static final Deity ODIN = Deity.builder() //
                                .name("odin") //
                                .type(CELESTIAL) //
                                .element(AIR) //
                                .alignment(GOOD) //
                                .putRelationship("zeus", HATED) //
                                .putRelationship("odin", SELF) //
                                .putRelationship("amun", INDIFFERENT) //
                                .putRelationship("tlaloc", LIKED) //
                                .putRelationship("huracan", DISLIKED) //
                                .putRelationship("demeter", INDIFFERENT) //
                                .putRelationship("ra", LIKED) //
                                .putRelationship("apollo", DISLIKED) //
                                .putRelationship("amaterasu", LOVED) //
                                .putRelationship("wirnpa", INDIFFERENT) //
                                .putRelationship("thor", LOVED) //
                                .putRelationship("baal", DISLIKED) //
                                .build(); //

                public static final Deity AMUN = Deity.builder() //
                                .name("amun") //
                                .type(CELESTIAL) //
                                .element(AIR) //
                                .alignment(GOOD) //
                                .putRelationship("zeus", LIKED) //
                                .putRelationship("odin", INDIFFERENT) //
                                .putRelationship("amun", SELF) //
                                .putRelationship("tlaloc", DISLIKED) //
                                .putRelationship("huracan", INDIFFERENT) //
                                .putRelationship("demeter", INDIFFERENT) //
                                .putRelationship("ra", LIKED) //
                                .putRelationship("apollo", LIKED) //
                                .putRelationship("amaterasu", INDIFFERENT) //
                                .putRelationship("wirnpa", LIKED) //
                                .putRelationship("thor", DISLIKED) //
                                .putRelationship("baal", DISLIKED) //
                                .build(); //

                // Earth //
                public static final Deity TLALOC = Deity.builder() //
                                .name("tlaloc") //
                                .type(CELESTIAL) //
                                .element(EARTH) //
                                .alignment(NEUTRAL) //
                                .putRelationship("zeus", INDIFFERENT) //
                                .putRelationship("odin", LIKED) //
                                .putRelationship("amun", LIKED) //
                                .putRelationship("tlaloc", SELF) //
                                .putRelationship("huracan", INDIFFERENT) //
                                .putRelationship("demeter", LIKED) //
                                .putRelationship("ra", DISLIKED) //
                                .putRelationship("apollo", LIKED) //
                                .putRelationship("amaterasu", DISLIKED) //
                                .putRelationship("wirnpa", DISLIKED) //
                                .putRelationship("thor", HATED) //
                                .putRelationship("baal", INDIFFERENT) //
                                .build(); //

                public static final Deity HURACAN = Deity.builder() //
                                .name("huracan") //
                                .type(CELESTIAL) //
                                .element(EARTH) //
                                .alignment(EVIL) //
                                .putRelationship("zeus", DISLIKED) //
                                .putRelationship("odin", INDIFFERENT) //
                                .putRelationship("amun", HATED) //
                                .putRelationship("tlaloc", LIKED) //
                                .putRelationship("huracan", SELF) //
                                .putRelationship("demeter", LIKED) //
                                .putRelationship("ra", HATED) //
                                .putRelationship("apollo", INDIFFERENT) //
                                .putRelationship("amaterasu", LIKED) //
                                .putRelationship("wirnpa", LIKED) //
                                .putRelationship("thor", LIKED) //
                                .putRelationship("baal", LOVED) //
                                .build(); //

                public static final Deity DEMETER = Deity.builder() //
                                .name("demeter") //
                                .type(CELESTIAL) //
                                .element(EARTH) //
                                .alignment(GOOD) //
                                .putRelationship("zeus", LOVED) //
                                .putRelationship("odin", LOVED) //
                                .putRelationship("amun", DISLIKED) //
                                .putRelationship("tlaloc", HATED) //
                                .putRelationship("huracan", INDIFFERENT) //
                                .putRelationship("demeter", SELF) //
                                .putRelationship("ra", LIKED) //
                                .putRelationship("apollo", LOVED) //
                                .putRelationship("amaterasu", HATED) //
                                .putRelationship("wirnpa", LIKED) //
                                .putRelationship("thor", HATED) //
                                .putRelationship("baal", INDIFFERENT) //
                                .build(); //

                // Fire //
                public static final Deity RA = Deity.builder() //
                                .name("ra") //
                                .type(CELESTIAL) //
                                .element(FIRE) //
                                .alignment(GOOD) //
                                .putRelationship("zeus", DISLIKED) //
                                .putRelationship("odin", LIKED) //
                                .putRelationship("amun", LOVED) //
                                .putRelationship("tlaloc", DISLIKED) //
                                .putRelationship("huracan", HATED) //
                                .putRelationship("demeter", LIKED) //
                                .putRelationship("ra", SELF) //
                                .putRelationship("apollo", LIKED) //
                                .putRelationship("amaterasu", LIKED) //
                                .putRelationship("wirnpa", INDIFFERENT) //
                                .putRelationship("thor", INDIFFERENT) //
                                .putRelationship("baal", DISLIKED) //
                                .build(); //

                public static final Deity APOLLO = Deity.builder() //
                                .name("apollo") //
                                .type(CELESTIAL) //
                                .element(FIRE) //
                                .alignment(NEUTRAL) //
                                .putRelationship("zeus", LOVED) //
                                .putRelationship("odin", HATED) //
                                .putRelationship("amun", LIKED) //
                                .putRelationship("tlaloc", INDIFFERENT) //
                                .putRelationship("huracan", DISLIKED) //
                                .putRelationship("demeter", DISLIKED) //
                                .putRelationship("ra", LIKED) //
                                .putRelationship("apollo", SELF) //
                                .putRelationship("amaterasu", LIKED) //
                                .putRelationship("wirnpa", LIKED) //
                                .putRelationship("thor", HATED) //
                                .putRelationship("baal", INDIFFERENT) //
                                .build(); //

                public static final Deity AMATERASU = Deity.builder() //
                                .name("amaterasu") //
                                .type(CELESTIAL) //
                                .element(FIRE) //
                                .alignment(GOOD) //
                                .putRelationship("zeus", HATED) //
                                .putRelationship("odin", LIKED) //
                                .putRelationship("amun", LIKED) //
                                .putRelationship("tlaloc", DISLIKED) //
                                .putRelationship("huracan", HATED) //
                                .putRelationship("demeter", HATED) //
                                .putRelationship("ra", LOVED) //
                                .putRelationship("apollo", DISLIKED) //
                                .putRelationship("amaterasu", SELF) //
                                .putRelationship("wirnpa", DISLIKED) //
                                .putRelationship("thor", LIKED) //
                                .putRelationship("baal", HATED) //
                                .build(); //

                // Water //
                public static final Deity WIRNPA = Deity.builder() //
                                .name("wirnpa") //
                                .type(CELESTIAL) //
                                .element(WATER) //
                                .alignment(NEUTRAL) //
                                .putRelationship("zeus", DISLIKED) //
                                .putRelationship("odin", DISLIKED) //
                                .putRelationship("amun", LIKED) //
                                .putRelationship("tlaloc", DISLIKED) //
                                .putRelationship("huracan", DISLIKED) //
                                .putRelationship("demeter", INDIFFERENT) //
                                .putRelationship("ra", LIKED) //
                                .putRelationship("apollo", DISLIKED) //
                                .putRelationship("amaterasu", INDIFFERENT) //
                                .putRelationship("wirnpa", SELF) //
                                .putRelationship("thor", LIKED) //
                                .putRelationship("baal", LIKED) //
                                .build(); //

                public static final Deity THOR = Deity.builder() //
                                .name("thor") //
                                .type(CELESTIAL) //
                                .element(WATER) //
                                .alignment(GOOD) //
                                .putRelationship("zeus", HATED) //
                                .putRelationship("odin", LOVED) //
                                .putRelationship("amun", DISLIKED) //
                                .putRelationship("tlaloc", HATED) //
                                .putRelationship("huracan", DISLIKED) //
                                .putRelationship("demeter", DISLIKED) //
                                .putRelationship("ra", LIKED) //
                                .putRelationship("apollo", HATED) //
                                .putRelationship("amaterasu", LOVED) //
                                .putRelationship("wirnpa", LIKED) //
                                .putRelationship("thor", SELF) //
                                .putRelationship("baal", DISLIKED) //
                                .build(); //

                public static final Deity BAAL = Deity.builder() //
                                .name("baal") //
                                .type(CELESTIAL) //
                                .element(WATER) //
                                .alignment(EVIL) //
                                .putRelationship("zeus", INDIFFERENT) //
                                .putRelationship("odin", INDIFFERENT) //
                                .putRelationship("amun", LIKED) //
                                .putRelationship("tlaloc", DISLIKED) //
                                .putRelationship("huracan", LIKED) //
                                .putRelationship("demeter", INDIFFERENT) //
                                .putRelationship("ra", HATED) //
                                .putRelationship("apollo", DISLIKED) //
                                .putRelationship("amaterasu", HATED) //
                                .putRelationship("wirnpa", LIKED) //
                                .putRelationship("thor", DISLIKED) //
                                .putRelationship("baal", SELF) //
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
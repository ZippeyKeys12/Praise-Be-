package com.zippeykeys.praisebe.deity

import com.google.common.collect.ImmutableMap
import com.zippeykeys.praisebe.deity.Deity.Alignment.EVIL
import com.zippeykeys.praisebe.deity.Deity.Alignment.GOOD
import com.zippeykeys.praisebe.deity.Deity.Alignment.NEUTRAL
import com.zippeykeys.praisebe.deity.Deity.Element.AIR
import com.zippeykeys.praisebe.deity.Deity.Element.EARTH
import com.zippeykeys.praisebe.deity.Deity.Element.FIRE
import com.zippeykeys.praisebe.deity.Deity.Element.WATER
import com.zippeykeys.praisebe.deity.Deity.Relationship
import com.zippeykeys.praisebe.deity.Deity.Relationship.DISLIKED
import com.zippeykeys.praisebe.deity.Deity.Relationship.HATED
import com.zippeykeys.praisebe.deity.Deity.Relationship.INDIFFERENT
import com.zippeykeys.praisebe.deity.Deity.Relationship.LIKED
import com.zippeykeys.praisebe.deity.Deity.Relationship.LOVED
import com.zippeykeys.praisebe.deity.Deity.Relationship.SELF
import com.zippeykeys.praisebe.deity.Deity.Type.CELESTIAL
import com.zippeykeys.praisebe.deity.Deity.Type.ETHEREAL
import com.zippeykeys.praisebe.deity.Deity.Type.TERRESTRIAL


object ModDeities {
    object Celestial {
        // Air
        val ZEUS = Deity(
                name = "zeus",
                type = CELESTIAL,
                element = AIR,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", SELF)
                        .put("odin", HATED)
                        .put("amun", LIKED)
                        .put("tlaloc", INDIFFERENT)
                        .put("huracan", LIKED)
                        .put("demeter", LOVED)
                        .put("ra", INDIFFERENT)
                        .put("apollo", LIKED)
                        .put("amaterasu", LOVED)
                        .put("wirnpa", INDIFFERENT)
                        .put("thor", DISLIKED)
                        .put("baal", INDIFFERENT).build()
        )

        val ODIN = Deity(
                name = "odin",
                type = CELESTIAL,
                element = AIR,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", HATED)
                        .put("odin", SELF)
                        .put("amun", INDIFFERENT)
                        .put("tlaloc", LIKED)
                        .put("huracan", DISLIKED)
                        .put("demeter", INDIFFERENT)
                        .put("ra", LIKED)
                        .put("apollo", DISLIKED)
                        .put("amaterasu", LOVED)
                        .put("wirnpa", INDIFFERENT)
                        .put("thor", LOVED)
                        .put("baal", DISLIKED)
                        .build()
        )

        val AMUN = Deity(
                name = "amun",
                type = CELESTIAL,
                element = AIR,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", LIKED)
                        .put("odin", INDIFFERENT)
                        .put("amun", SELF)
                        .put("tlaloc", DISLIKED)
                        .put("huracan", INDIFFERENT)
                        .put("demeter", INDIFFERENT)
                        .put("ra", LIKED)
                        .put("apollo", LIKED)
                        .put("amaterasu", INDIFFERENT)
                        .put("wirnpa", LIKED)
                        .put("thor", DISLIKED)
                        .put("baal", DISLIKED)
                        .build()
        )

        // Earth 
        val TLALOC = Deity(
                name = "tlaloc",
                type = CELESTIAL,
                element = EARTH,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", INDIFFERENT)
                        .put("odin", LIKED)
                        .put("amun", LIKED)
                        .put("tlaloc", SELF)
                        .put("huracan", INDIFFERENT)
                        .put("demeter", LIKED)
                        .put("ra", DISLIKED)
                        .put("apollo", LIKED)
                        .put("amaterasu", DISLIKED)
                        .put("wirnpa", DISLIKED)
                        .put("thor", HATED)
                        .put("baal", INDIFFERENT)
                        .build()
        )

        val HURACAN = Deity(
                name = "huracan",
                type = CELESTIAL,
                element = EARTH,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", DISLIKED)
                        .put("odin", INDIFFERENT)
                        .put("amun", HATED)
                        .put("tlaloc", LIKED)
                        .put("huracan", SELF)
                        .put("demeter", LIKED)
                        .put("ra", HATED)
                        .put("apollo", INDIFFERENT)
                        .put("amaterasu", LIKED)
                        .put("wirnpa", LIKED)
                        .put("thor", LIKED)
                        .put("baal", LOVED)
                        .build()
        )

        val DEMETER = Deity(
                name = "demeter",
                type = CELESTIAL,
                element = EARTH,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", LOVED)
                        .put("odin", LOVED)
                        .put("amun", DISLIKED)
                        .put("tlaloc", HATED)
                        .put("huracan", INDIFFERENT)
                        .put("demeter", SELF)
                        .put("ra", LIKED)
                        .put("apollo", LOVED)
                        .put("amaterasu", HATED)
                        .put("wirnpa", LIKED)
                        .put("thor", HATED)
                        .put("baal", INDIFFERENT)
                        .build()
        )

        // Fire 
        val RA = Deity(
                name = "ra",
                type = CELESTIAL,
                element = FIRE,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", DISLIKED)
                        .put("odin", LIKED)
                        .put("amun", LOVED)
                        .put("tlaloc", DISLIKED)
                        .put("huracan", HATED)
                        .put("demeter", LIKED)
                        .put("ra", SELF)
                        .put("apollo", LIKED)
                        .put("amaterasu", LIKED)
                        .put("wirnpa", INDIFFERENT)
                        .put("thor", INDIFFERENT)
                        .put("baal", DISLIKED)
                        .build()
        )

        val APOLLO = Deity(
                name = "apollo",
                type = CELESTIAL,
                element = FIRE,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", LOVED)
                        .put("odin", HATED)
                        .put("amun", LIKED)
                        .put("tlaloc", INDIFFERENT)
                        .put("huracan", DISLIKED)
                        .put("demeter", DISLIKED)
                        .put("ra", LIKED)
                        .put("apollo", SELF)
                        .put("amaterasu", LIKED)
                        .put("wirnpa", LIKED)
                        .put("thor", HATED)
                        .put("baal", INDIFFERENT)
                        .build()
        )

        val AMATERASU = Deity(
                name = "amaterasu",
                type = CELESTIAL,
                element = FIRE,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", HATED)
                        .put("odin", LIKED)
                        .put("amun", LIKED)
                        .put("tlaloc", DISLIKED)
                        .put("huracan", HATED)
                        .put("demeter", HATED)
                        .put("ra", LOVED)
                        .put("apollo", DISLIKED)
                        .put("amaterasu", SELF)
                        .put("wirnpa", DISLIKED)
                        .put("thor", LIKED)
                        .put("baal", HATED)
                        .build()
        )

        // Water 
        val WIRNPA = Deity(
                name = "wirnpa",
                type = CELESTIAL,
                element = WATER,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", DISLIKED)
                        .put("odin", DISLIKED)
                        .put("amun", LIKED)
                        .put("tlaloc", DISLIKED)
                        .put("huracan", DISLIKED)
                        .put("demeter", INDIFFERENT)
                        .put("ra", LIKED)
                        .put("apollo", DISLIKED)
                        .put("amaterasu", INDIFFERENT)
                        .put("wirnpa", SELF)
                        .put("thor", LIKED)
                        .put("baal", LIKED)
                        .build()
        )

        val THOR = Deity(
                name = "thor",
                type = CELESTIAL,
                element = WATER,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", HATED)
                        .put("odin", LOVED)
                        .put("amun", DISLIKED)
                        .put("tlaloc", HATED)
                        .put("huracan", DISLIKED)
                        .put("demeter", DISLIKED)
                        .put("ra", LIKED)
                        .put("apollo", HATED)
                        .put("amaterasu", LOVED)
                        .put("wirnpa", LIKED)
                        .put("thor", SELF)
                        .put("baal", DISLIKED)
                        .build()
        )

        val BAAL = Deity(
                name = "baal",
                type = CELESTIAL,
                element = WATER,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("zeus", INDIFFERENT)
                        .put("odin", INDIFFERENT)
                        .put("amun", LIKED)
                        .put("tlaloc", DISLIKED)
                        .put("huracan", LIKED)
                        .put("demeter", INDIFFERENT)
                        .put("ra", HATED)
                        .put("apollo", DISLIKED)
                        .put("amaterasu", HATED)
                        .put("wirnpa", LIKED)
                        .put("thor", DISLIKED)
                        .put("baal", SELF)
                        .build()
        )
    }

    object Terrestrial {
        // Air 
        val MORRIGAN = Deity(
                name = "morrigan",
                type = TERRESTRIAL,
                element = AIR,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", SELF)
                        .put("njord", INDIFFERENT)
                        .put("tezc", LIKED)
                        .put("dagda", LOVED)
                        .put("pan", HATED)
                        .put("dagon", LIKED)
                        .put("heph", DISLIKED)
                        .put("grannus", LIKED)
                        .put("xiuh", INDIFFERENT)
                        .put("poseidon", HATED)
                        .put("sirona", LIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        val NJORD = Deity(
                name = "njord",
                type = TERRESTRIAL,
                element = AIR,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", INDIFFERENT)
                        .put("njord", SELF)
                        .put("tezc", DISLIKED)
                        .put("dagda", DISLIKED)
                        .put("pan", LIKED)
                        .put("dagon", INDIFFERENT)
                        .put("heph", INDIFFERENT)
                        .put("grannus", DISLIKED)
                        .put("xiuh", LIKED)
                        .put("poseidon", LIKED)
                        .put("sirona", DISLIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        val TEZCCATLIPOCA = Deity(
                name = "tezc",
                type = TERRESTRIAL,
                element = AIR,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", LIKED)
                        .put("njord", DISLIKED)
                        .put("tezc", SELF)
                        .put("dagda", LIKED)
                        .put("pan", LIKED)
                        .put("dagon", LIKED)
                        .put("heph", DISLIKED)
                        .put("grannus", INDIFFERENT)
                        .put("xiuh", INDIFFERENT)
                        .put("poseidon", DISLIKED)
                        .put("sirona", LIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        // Earth 
        val DAGDA = Deity(
                name = "dagda",
                type = TERRESTRIAL,
                element = EARTH,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", LOVED)
                        .put("njord", INDIFFERENT)
                        .put("tezc", LIKED)
                        .put("dagda", SELF)
                        .put("pan", HATED)
                        .put("dagon", LIKED)
                        .put("heph", INDIFFERENT)
                        .put("grannus", LIKED)
                        .put("xiuh", INDIFFERENT)
                        .put("poseidon", DISLIKED)
                        .put("sirona", LIKED)
                        .put("lotan", HATED)
                        .build()
        )

        val PAN = Deity(
                name = "pan",
                type = TERRESTRIAL,
                element = EARTH,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", HATED)
                        .put("njord", LIKED)
                        .put("tezc", INDIFFERENT)
                        .put("dagda", HATED)
                        .put("pan", SELF)
                        .put("dagon", DISLIKED)
                        .put("heph", LIKED)
                        .put("grannus", INDIFFERENT)
                        .put("xiuh", LIKED)
                        .put("poseidon", LIKED)
                        .put("sirona", DISLIKED)
                        .put("lotan", LIKED)
                        .build()
        )

        val DAGON = Deity(
                name = "dagon",
                type = TERRESTRIAL,
                element = EARTH,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", DISLIKED)
                        .put("njord", LIKED)
                        .put("tezc", DISLIKED)
                        .put("dagda", LIKED)
                        .put("pan", DISLIKED)
                        .put("dagon", SELF)
                        .put("heph", DISLIKED)
                        .put("grannus", LIKED)
                        .put("xiuh", INDIFFERENT)
                        .put("poseidon", DISLIKED)
                        .put("sirona", LIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        // Fire 
        val HEPHAESTUS = Deity(
                name = "heph",
                type = TERRESTRIAL,
                element = FIRE,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", DISLIKED)
                        .put("njord", LIKED)
                        .put("tezc", INDIFFERENT)
                        .put("dagda", DISLIKED)
                        .put("pan", LIKED)
                        .put("dagon", DISLIKED)
                        .put("heph", SELF)
                        .put("grannus", LIKED)
                        .put("xiuh", INDIFFERENT)
                        .put("poseidon", DISLIKED)
                        .put("sirona", DISLIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        val GRANNUS = Deity(
                name = "grannus",
                type = TERRESTRIAL,
                element = FIRE,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", LIKED)
                        .put("njord", DISLIKED)
                        .put("tezc", INDIFFERENT)
                        .put("dagda", LIKED)
                        .put("pan", INDIFFERENT)
                        .put("dagon", LIKED)
                        .put("heph", LIKED)
                        .put("grannus", SELF)
                        .put("xiuh", INDIFFERENT)
                        .put("poseidon", DISLIKED)
                        .put("sirona", LIKED)
                        .put("lotan", HATED)
                        .build()
        )

        val XIUHTECUHTLI = Deity(
                name = "xiuh",
                type = TERRESTRIAL,
                element = FIRE,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", INDIFFERENT)
                        .put("njord", LIKED)
                        .put("tezc", INDIFFERENT)
                        .put("dagda", LIKED)
                        .put("pan", DISLIKED)
                        .put("dagon", INDIFFERENT)
                        .put("heph", LIKED)
                        .put("grannus", LIKED)
                        .put("xiuh", SELF)
                        .put("poseidon", INDIFFERENT)
                        .put("sirona", LIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        // Water 
        val POSEIDON = Deity(
                name = "poseidon",
                type = TERRESTRIAL,
                element = WATER,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", HATED)
                        .put("njord", LIKED)
                        .put("tezc", DISLIKED)
                        .put("dagda", DISLIKED)
                        .put("pan", LIKED)
                        .put("dagon", DISLIKED)
                        .put("heph", LIKED)
                        .put("grannus", DISLIKED)
                        .put("xiuh", DISLIKED)
                        .put("poseidon", SELF)
                        .put("sirona", DISLIKED)
                        .put("lotan", DISLIKED)
                        .build()
        )

        val SIRONA = Deity(
                name = "sirona",
                type = TERRESTRIAL,
                element = WATER,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", LIKED)
                        .put("njord", DISLIKED)
                        .put("tezc", LIKED)
                        .put("dagda", LIKED)
                        .put("pan", DISLIKED)
                        .put("dagon", LIKED)
                        .put("heph", DISLIKED)
                        .put("grannus", LIKED)
                        .put("xiuh", LIKED)
                        .put("poseidon", DISLIKED)
                        .put("sirona", SELF)
                        .put("lotan", DISLIKED)
                        .build()
        )

        val LOTAN = Deity(
                name = "lotan",
                type = TERRESTRIAL,
                element = WATER,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .put("morrigan", DISLIKED)
                        .put("njord", DISLIKED)
                        .put("tezc", DISLIKED)
                        .put("dagda", HATED)
                        .put("pan", LIKED)
                        .put("dagon", DISLIKED)
                        .put("heph", DISLIKED)
                        .put("grannus", HATED)
                        .put("xiuh", DISLIKED)
                        .put("poseidon", DISLIKED)
                        .put("sirona", DISLIKED)
                        .put("lotan", SELF)
                        .build()
        )

    }

    object Ethereal {
        // Air 
        val NYARLATHOTEP = Deity(
                name = "nyar",
                type = ETHEREAL,
                element = AIR,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val FUJIN = Deity(
                name = "fujin",
                type = ETHEREAL,
                element = AIR,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val RAIJIN = Deity(
                name = "raijin",
                type = ETHEREAL,
                element = AIR,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        // Earth 
        val SHUB_NIGGURATH = Deity(
                name = "shub",
                type = ETHEREAL,
                element = EARTH,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val ATUM = Deity(
                name = "atum",
                type = ETHEREAL,
                element = EARTH,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val ANUBIS = Deity(
                name = "anubis",
                type = ETHEREAL,
                element = EARTH,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        // Fire 
        val HADES = Deity(
                name = "hades",
                type = ETHEREAL,
                element = FIRE,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val MOLOCH = Deity(
                name = "moloch",
                type = ETHEREAL,
                element = FIRE,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val PEKELNYBOG = Deity(
                name = "pekel",
                type = ETHEREAL,
                element = FIRE,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        // Water 
        val CTHULU = Deity(
                name = "cthulu",
                type = ETHEREAL,
                element = WATER,
                alignment = EVIL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val OSIRIS = Deity(
                name = "osiris",
                type = ETHEREAL,
                element = WATER,
                alignment = NEUTRAL,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )

        val CHARON = Deity(
                name = "charon",
                type = ETHEREAL,
                element = WATER,
                alignment = GOOD,
                relationships = ImmutableMap.builder<String, Relationship>()
                        .build()
        )
    }
}
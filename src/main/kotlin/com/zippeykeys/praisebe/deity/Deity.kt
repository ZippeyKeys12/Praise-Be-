package com.zippeykeys.praisebe.deity

import com.google.common.collect.ImmutableMap
import com.zippeykeys.praisebe.iface.ILocalize
import net.minecraftforge.registries.IForgeRegistryEntry

data class Deity constructor(private val name: String, val type: Type, val element: Element, val alignment: Alignment, val relationships: ImmutableMap<String, Relationship>) : IForgeRegistryEntry.Impl<Deity>(), ILocalize {
    override val prefix: String
        get() = "deity"

    override fun getName(): String {
        return name
    }

    fun getRelationship(deity: Deity): Relationship? {
        return getRelationship(deity.name)
    }

    fun getRelationship(deity: String): Relationship? {
        return relationships[deity]
    }

    enum class Type constructor(private val actualName: String) : ILocalize {
        TERRESTRIAL("terrestrial"),
        CELESTIAL("celestial"),
        ETHEREAL("ethereal");

        override val prefix: String
            get() = "deity.type"

        override fun getName(): String {
            return actualName
        }
    }

    enum class Element constructor(private val actualName: String) : ILocalize {
        AIR("air"),
        EARTH("earth"),
        FIRE("fire"),
        WATER("water");

        override val prefix: String
            get() = "deity.element"

        override fun getName(): String {
            return actualName
        }
    }

    enum class Alignment constructor(private val actualName: String) : ILocalize {
        GOOD("good"),
        NEUTRAL("neutral"),
        EVIL("evil");

        override val prefix: String
            get() = "deity.alignment"

        override fun getName(): String {
            return actualName
        }
    }

    enum class Relationship constructor(private val actualName: String) : ILocalize {
        HATED("hated"),
        DISLIKED("disliked"),
        INDIFFERENT("indifferent"),
        LIKED("liked"),
        LOVED("loved"),
        SELF("self");

        override val prefix: String
            get() = "deity.relationship"

        override fun getName(): String {
            return actualName
        }
    }
}
package com.zippeykeys.praisebe.registry

import com.zippeykeys.praisebe.deity.Deity
import com.zippeykeys.praisebe.util.getResource
import net.minecraftforge.registries.IForgeRegistry
import java.util.Arrays
import java.util.Objects
import java.util.stream.Stream
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DeityRegistry @Inject constructor(registryIn: IForgeRegistry<Deity>) :
        PBRegistry<Deity>(Deity.Type::class.java, Deity.Element::class.java, Deity.Alignment::class.java) {
    init {
        registryIn.valuesCollection.forEach { this.register(it) }
    }

    fun register(value: Deity): Deity? {
        return set(getResource(value.name), value)
    }

    fun registerAll(vararg values: Deity): Array<Deity> {
        return registerAll(Arrays.stream(values))
    }

    fun registerAll(values: Collection<Deity>): Array<Deity> {
        return registerAll(values.stream())
    }

    @Suppress("UNCHECKED_CAST")
    fun registerAll(values: Stream<out Deity>): Array<Deity> {
        return values.map { register(it) }
                .filter(Objects::nonNull) // Maybe shouldn't clean
                .toArray() as Array<Deity>
    }
}
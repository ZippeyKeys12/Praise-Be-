package com.zippeykeys.praisebe.registry

import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableSet
import com.zippeykeys.praisebe.util.getFieldValueByClass
import net.minecraft.util.ResourceLocation
import java.lang.reflect.InvocationTargetException
import java.util.Arrays
import java.util.HashMap
import java.util.HashSet
import java.util.function.BiConsumer

open class PBRegistry<T>(classifiersIn: List<Class<out Enum<*>>>) {
    protected val classifiers: ImmutableSet<Class<out Enum<*>>> = ImmutableSet.builder<Class<out Enum<*>>>()
            .addAll(classifiersIn)
            .build()

    protected val classes: MutableMap<String, T>

    protected val categorized: Map<Class<out Enum<*>>, MutableMap<out Enum<*>, MutableSet<T>>>

    @SafeVarargs
    constructor(vararg classifiersIn: Class<out Enum<*>>) : this(Arrays.asList<Class<out Enum<*>>>(*classifiersIn))

    init {
        classes = HashMap()

        val builder = ImmutableMap.builder<Class<out Enum<*>>, MutableMap<Enum<*>, MutableSet<T>>>()
        for (clazz in classifiersIn) {
            try {
                val map = mutableMapOf<Enum<*>, MutableSet<T>>()
                for (enumVal in clazz.enumConstants) {
                    map[enumVal] = HashSet()
                }
                builder.put(clazz, map)
            } catch (ignored: InstantiationException) {
            } catch (ignored: IllegalAccessException) {
            } catch (ignored: IllegalArgumentException) {
            } catch (ignored: InvocationTargetException) {
            } catch (ignored: NoSuchMethodException) {
            } catch (ignored: SecurityException) {
            }

        }
        categorized = builder.build()
        categorized.forEach { k, v ->
            for (enumValue in k.enumConstants) {
                v[enumValue] = HashSet()
            }
        }
    }

    operator fun set(key: ResourceLocation, value: T): T? {
        return set(key.toString(), value)
    }

    operator fun set(key: String, value: T): T? {
        val previousValue = classes.put(key, value)
        for (clazz in classifiers) {
            val type = clazz.cast(getFieldValueByClass(value!!, clazz)) ?: continue
            val map = categorized[clazz]
            map!![type]?.plus(value)
        }
        return previousValue
    }

    fun unregister(key: ResourceLocation): T? {
        return unregister(key.toString())
    }

    fun unregister(key: String): T? {
        val value = classes.remove(key)
        if (value != null)
            for (clazz in classifiers) {
                categorized[clazz]!![clazz.cast(getFieldValueByClass(value, clazz)) ?: continue]!!.remove(value)
            }
        return value
    }

    operator fun get(key: ResourceLocation): T? {
        return get(key.toString())
    }

    operator fun get(key: String): T? {
        return classes[key]
    }

    fun <C : Enum<C>> getRandom(key: C): T {
        return getSet(key).random()
    }

    fun <C : Enum<C>> getSet(key: C): Set<T> {
        return ImmutableSet.builder<T>()
                .addAll(categorized[key.javaClass]!![key]!!)
                .build()
    }

    operator fun contains(key: ResourceLocation): Boolean {
        return contains(key.toString())
    }

    operator fun contains(key: String): Boolean {
        return get(key) != null
    }

    fun entries(): ImmutableMap<String, T> {
        return ImmutableMap.builder<String, T>()
                .putAll(classes)
                .build()
    }

    fun keySet(): ImmutableSet<String> {
        return ImmutableSet.builder<String>()
                .addAll(classes.keys)
                .build()
    }

    fun values(): ImmutableSet<T> {
        return ImmutableSet.builder<T>()
                .addAll(classes.values)
                .build()
    }

    fun forEach(action: BiConsumer<in String, in T>) {
        classes.forEach(action)
    }
}
package com.zippeykeys.praisebe.util

import java.util.EnumMap


inline operator fun <reified T : Enum<T>> T.get(index: Int): T {
    return enumValues<T>()[index]
}

fun enumSize(clazz:Class<*>): Int {
    return clazz.enumConstants.size
}

fun enumIndices(clazz:Class<*>): IntRange {
    return clazz.enumConstants.indices
}

inline fun <reified K : Enum<K>, V> List<V>.toEnumMap(): EnumMap<K, V> {
    return enumValues<K>().zip(this)
            .toMap(EnumMap(K::class.java))
}
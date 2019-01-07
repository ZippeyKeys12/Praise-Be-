package com.zippeykeys.praisebe.util

import org.apache.commons.lang3.ArrayUtils
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.InvocationTargetException


@Suppress("UNCHECKED_CAST")
fun <T> newInstance(className: String): T? {
    return try {
        newInstance(Class.forName(className) as Class<T>)
    } catch (ignored: ClassNotFoundException) {
        null
    }

}

fun <T> newInstance(clazz: Class<T>): T? {
    return try {
        clazz.newInstance()
    } catch (ignored: InstantiationException) {
        null
    } catch (ignored: IllegalAccessException) {
        null
    }

}

fun <T> newInstance(constructor: Constructor<T>, vararg parameters: Any): T? {
    return try {
        constructor.newInstance(*parameters)
    } catch (ignored: InstantiationException) {
        null
    } catch (ignored: IllegalAccessException) {
        null
    } catch (ignored: IllegalArgumentException) {
        null
    } catch (ignored: InvocationTargetException) {
        null
    }

}

inline fun <reified T> getConstructor(vararg parameterTypes: Class<*>): Constructor<T>? {
    return try {
        T::class.java.getConstructor(*parameterTypes)
    } catch (ignored: IllegalArgumentException) {
        null
    } catch (ignored: NoSuchMethodException) {
        null
    } catch (ignored: SecurityException) {
        null
    }

}

@JvmOverloads
fun getFieldValue(field: Field, instance: Any? = null): Any? {
    return try {
        field.get(instance)
    } catch (ignored: IllegalArgumentException) {
        null
    } catch (ignored: IllegalAccessException) {
        null
    }

}

inline fun <reified T> callDeclaredMethod(methodName: String, instance: Any): Any? {
    return try {
        T::class.java.getDeclaredMethod(methodName)
                .invoke(instance)
    } catch (ignored: IllegalAccessException) {
        null
    } catch (ignored: IllegalArgumentException) {
        null
    } catch (ignored: InvocationTargetException) {
        null
    } catch (ignored: NoSuchMethodException) {
        null
    } catch (ignored: SecurityException) {
        null
    }

}

fun getDeclaredFields(vararg classes: Class<*>): Array<Field?> {
    var results = arrayOfNulls<Field>(0)
    for (clazz in classes) {
        results = ArrayUtils.addAll<Field>(results, *clazz.declaredFields)
    }
    return results
}

fun getFieldValueByClass(caller: Any, gotten: Class<*>): Any? {
    return try {
        caller.javaClass
                .getMethod("get" + gotten.simpleName)
                .invoke(null)
    } catch (ignored: NoSuchMethodException) {
        null
    } catch (ignored: IllegalAccessException) {
        null
    } catch (ignored: IllegalArgumentException) {
        null
    } catch (ignored: InvocationTargetException) {
        null
    } catch (ignored: SecurityException) {
        null
    }

}
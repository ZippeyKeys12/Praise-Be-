package com.zippeykeys.praisebe.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.var;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClassUtil {
    public static @Nullable <T> T newInstance(@NotNull Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ignored) {
        }
        return null;
    }

    public static @Nullable <T> T newInstance(@NotNull Class<T> clazz, Object... parameters) {
        try {
            return clazz.getConstructor(Arrays.stream(parameters) //
                    .map(Object::getClass) //
                    .toArray(Class<?>[]::new)) //
                    .newInstance(parameters);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException ignored) {
        }
        return null;
    }

    public static @Nullable Object getFieldValue(Field field) {
        return getFieldValue(field, null);
    }

    public static @Nullable Object getFieldValue(@NotNull Field field, Object instance) {
        try {
            return field.get(instance);
        } catch (IllegalArgumentException | IllegalAccessException ignored) {
        }
        return null;
    }

    public static @Nullable Object callDeclaredMethod(@NotNull Class<?> clazz, String methodName, Object instance,
            Object... parameters) {
        try {
            return clazz.getDeclaredMethod(methodName).invoke(instance, parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException ignored) {
        }
        return null;
    }

    public static Field[] getDeclaredFields(@NotNull Class<?>... classes) {
        var results = new Field[0];
        for (var clazz : classes) {
            results = ArrayUtils.addAll(results, clazz.getDeclaredFields());
        }
        return results;
    }

    public static @Nullable Object getFieldValueByClass(@NotNull Object caller, @NotNull Class<?> gotten) {
        try {
            return caller.getClass().getMethod("get" + gotten.getSimpleName()).invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | SecurityException ignored) {
        }
        return null;
    }
}
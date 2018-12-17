package com.zippeykeys.praisebe.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.var;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClassUtil {
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

    public static @Nullable Object callDeclaredMethod(@NotNull Class<?> clazz, String methodName,
            Object... parameters) {
        try {
            return clazz.getDeclaredMethod(methodName).invoke(parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException ignored) {
        }
        return null;
    }

    public static Field[] getDeclaredFields(Class<?>... classes) {
        var results = new Field[0];
        for (var clazz : classes) {
            results = ArrayUtils.<Field>addAll(results, clazz.getDeclaredFields());
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
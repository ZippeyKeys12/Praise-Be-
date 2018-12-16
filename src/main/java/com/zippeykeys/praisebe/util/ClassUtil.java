package com.zippeykeys.praisebe.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    public static @Nullable Object getFieldValueByClass(@NotNull Object caller, @NotNull Class<?> gotten) {
        try {
            return caller.getClass().getMethod("get" + gotten.getSimpleName()).invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | SecurityException ignored) {
        }
        return null;
    }

    public static <T> T cast(@NotNull Class<T> clazz, Object obj) {
        return clazz.cast(obj);
    }
}
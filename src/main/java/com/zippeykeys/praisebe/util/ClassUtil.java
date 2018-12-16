package com.zippeykeys.praisebe.util;

import java.lang.reflect.InvocationTargetException;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassUtil {
    public static @Nullable Object getClassedField(@NotNull Object caller, @NotNull Class<?> gotten) {
        try {
            return caller.getClass().getMethod("get" + gotten.getSimpleName()).invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | SecurityException ignored) {
        }
        return null;
    }
}
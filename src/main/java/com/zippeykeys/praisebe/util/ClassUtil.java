package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassUtil {
    public static @Nullable Object getMethodForClass(@NotNull Object caller, @NotNull Class<?> gotten) {
        try {
            return caller.getClass().getMethod("get" + gotten.getSimpleName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
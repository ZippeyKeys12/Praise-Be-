package com.zippeykeys.praisebe.util;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

import lombok.var;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;

@UtilityClass
@ExtensionMethod(Arrays.class)
public class EnumUtil {
    public static <T extends Enum<T>> int getIndex(T enumVar) {
        return getValues(enumVar).asList().indexOf(enumVar);
    }

    public static <T extends Enum<T>> Enum<T> byIndex(T enumType, int index) {
        return getValues(enumType)[index];
    }

    public static <T extends Enum<T>> int getSize(T enumVar) {
        return getValues(enumVar).length;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Enum<T>[] getValues(@NotNull T enumVar) {
        return getValues((Class<T>) enumVar.getClass());
    }

    public static <T extends Enum<T>> Enum<T>[] getValues(@NotNull Class<T> enumVar) {
        return enumVar.getEnumConstants();
    }

    @SafeVarargs
    public static <T extends Enum<T>> int getUniqueIndex(@NotNull T... enums) {
        int result = getIndex(enums[0]);
        enums = enums.copyOfRange(1, enums.length);
        for (var enumVar : enums) {
            result = getIndex(enumVar) + getSize(enumVar) * result;
        }
        return result;
    }
}
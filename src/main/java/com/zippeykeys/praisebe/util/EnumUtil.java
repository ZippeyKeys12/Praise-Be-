package com.zippeykeys.praisebe.util;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

import lombok.var;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EnumUtil {

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
        int result = enums[0].ordinal();
        enums = Arrays.copyOfRange(enums, 1, enums.length);
        for (var enumVar : enums) {
            result = enumVar.ordinal() + getSize(enumVar) * result;
        }
        return result;
    }
}
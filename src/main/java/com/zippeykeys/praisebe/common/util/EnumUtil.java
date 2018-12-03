package com.zippeykeys.praisebe.common.util;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

import lombok.var;

public final class EnumUtil {
    private EnumUtil() {
    }

    public static int getIndex(Enum<?> enumVar) {
        return Arrays.asList(getValues(enumVar)).indexOf(enumVar);
    }

    public static <T extends Enum<T>> Enum<T> byIndex(Enum<T> enumType, int index) {
        return getValues(enumType)[index];
    }

    public static int getSize(Enum<?> enumVar) {
        return getValues(enumVar).length;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Enum<T>[] getValues(@NotNull Enum<T> enumVar) {
        return enumVar.getClass().getEnumConstants();
    }

    public static int getUniqueIndex(@NotNull Enum<?>... enums) {
        int result = getIndex(enums[0]);
        enums = Arrays.copyOfRange(enums, 1, enums.length);
        for (var enumVar : enums) {
            result = getIndex(enumVar) + getSize(enumVar) * result;
        }
        return result;
    }
}
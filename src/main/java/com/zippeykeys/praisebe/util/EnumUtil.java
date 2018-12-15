package com.zippeykeys.praisebe.util;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

import lombok.var;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;

@UtilityClass
@ExtensionMethod(Arrays.class)
public class EnumUtil {
    public static int getIndex(Enum<?> enumVar) {
        return getValues(enumVar).asList().indexOf(enumVar);
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
        enums = enums.copyOfRange(1, enums.length);
        for (var enumVar : enums) {
            result = getIndex(enumVar) + getSize(enumVar) * result;
        }
        return result;
    }
}
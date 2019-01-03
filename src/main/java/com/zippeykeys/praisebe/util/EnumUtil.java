package com.zippeykeys.praisebe.util;

import java.util.Arrays;

import lombok.experimental.UtilityClass;
import lombok.var;


@UtilityClass
public class EnumUtil{
    public static <T extends Enum<T>> Enum<T> byIndex(T enumType, int index){
        return getValues(enumType)[index];
    }

    public static <T extends Enum<T>> int getSize(T enumVar){
        return getValues(enumVar).length;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Enum<T>[] getValues(T enumVar){
        return getValues((Class<T>) enumVar.getClass());
    }

    public static <T extends Enum<T>> Enum<T>[] getValues(Class<? extends T> enumVar){
        return enumVar.getEnumConstants();
    }

    @SafeVarargs
    public static <T extends Enum<T>> int getUniqueIndex(T... enums){
        int result = enums[0].ordinal();
        T[] x = Arrays.copyOfRange(enums, 1, enums.length);
        for(var enumVar : x){
            result = enumVar.ordinal() + getSize(enumVar) * result;
        }
        return result;
    }
}
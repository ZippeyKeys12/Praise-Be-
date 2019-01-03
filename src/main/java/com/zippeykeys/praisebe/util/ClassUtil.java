package com.zippeykeys.praisebe.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import lombok.experimental.UtilityClass;
import lombok.var;


@UtilityClass
public class ClassUtil{
    @SuppressWarnings("unchecked")
    public static @Nullable <T> T newInstance(String className){
        try{
            return newInstance((Class<T>) Class.forName(className));
        }catch(ClassNotFoundException ignored){
            return null;
        }
    }

    public static @Nullable <T> T newInstance(Class<T> clazz){
        try{
            return clazz.newInstance();
        }catch(InstantiationException | IllegalAccessException ignored){
            return null;
        }
    }

    public static @Nullable <T> T newInstance(Constructor<T> constructor, Object... parameters){
        try{
            return constructor.newInstance(parameters);
        }catch(InstantiationException | IllegalAccessException | IllegalArgumentException
          | InvocationTargetException ignored){
            return null;
        }
    }

    public static @Nullable <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes){
        try{
            return clazz.getConstructor(parameterTypes);
        }catch(IllegalArgumentException | NoSuchMethodException | SecurityException ignored){
            return null;
        }
    }

    public static @Nullable Object getFieldValue(Field field){
        return getFieldValue(field, null);
    }

    public static @Nullable Object getFieldValue(Field field, @Nullable Object instance){
        try{
            return field.get(instance);
        }catch(IllegalArgumentException | IllegalAccessException ignored){
            return null;
        }
    }

    public static @Nullable Object callDeclaredMethod(Class<?> clazz, String methodName, Object instance){
        try{
            return clazz.getDeclaredMethod(methodName)
              .invoke(instance);
        }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
          | SecurityException ignored){
            return null;
        }
    }

    public static Field[] getDeclaredFields(Class<?>... classes){
        var results = new Field[0];
        for(var clazz : classes){
            results = ArrayUtils.addAll(results, clazz.getDeclaredFields());
        }
        return results;
    }

    public static @Nullable Object getFieldValueByClass(Object caller, Class<?> gotten){
        try{
            return caller.getClass()
              .getMethod("get" + gotten.getSimpleName())
              .invoke(null);
        }catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
          | SecurityException ignored){
            return null;
        }
    }
}
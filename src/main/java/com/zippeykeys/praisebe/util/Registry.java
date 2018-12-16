package com.zippeykeys.praisebe.util;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.val;
import lombok.var;
import net.minecraft.util.ResourceLocation;

public class Registry<T> {
    protected final Set<Class<? extends Enum<?>>> classifiers;

    protected final Map<ResourceLocation, T> classes;

    protected final Map<Class<? extends Enum<?>>, Map<Enum<?>, Set<T>>> categorized;

    public final Class<T> CLAZZ_T;

    @SafeVarargs
    @Contract("_, _ -> new")
    public static @NotNull <T> Registry<T> of(Class<T> clazzT, Class<? extends Enum<?>>... classifiers) {
        return new Registry<T>(clazzT, classifiers);
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public Registry(Class<T> clazzT, Class<? extends Enum<?>>... classifiers) {
        CLAZZ_T = clazzT;
        this.classifiers = ImmutableSet.<Class<? extends Enum<?>>>builder().add(classifiers).build();
        classes = new HashMap<>();
        val builder = ImmutableMap.<Class<? extends Enum<?>>, Map<Enum<?>, Set<T>>>builder();
        for (var clazz : classifiers) {
            try {
                builder.put(clazz, EnumMap.class.getConstructor(Class.class).newInstance(clazz));
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException ignored) {
            }
        }
        categorized = builder.build();
        categorized.forEach((k, v) -> {
            for (var enumValue : k.getEnumConstants()) {
                v.put(enumValue, new HashSet<>());
            }
        });
    }

    public T register(ResourceLocation key, T value) {
        val previousValue = classes.put(key, value);
        for (var clazz : classifiers) {
            var type = Enum.class.cast(ClassUtil.getClassedField(value, clazz));
            if (type == null) {
                continue;
            }

            var map = categorized.get(clazz);
            map.get(type).add(value);
        }
        return previousValue;
    }

    public T unregister(ResourceLocation key) {
        val value = classes.remove(key);
        for (var clazz : classifiers) {
            var type = CLAZZ_T.cast(ClassUtil.getClassedField(value, clazz));
            if (type == null) {
                continue;
            }

            var map = categorized.get(clazz);
            var set = map.get(type);

            set.remove(value);
        }
        return value;
    }

    public T get(String key) {
        return get(new ResourceLocation(key));
    }

    public T get(ResourceLocation key) {
        return classes.get(key);
    }

    @SuppressWarnings("unchecked")
    public T getRandom(Enum<?> key) {
        val set = getSet(key);
        return ((T[]) set.toArray())[new Random().nextInt(set.size())];
    }

    public Set<T> getSet(Enum<?> key) {
        return ImmutableSet.<T>builder().addAll(categorized.get(key.getClass()).get(key)).build();
    }

    public void forEach(BiConsumer<? super ResourceLocation, ? super T> action) {
        classes.forEach(action);
    }
}
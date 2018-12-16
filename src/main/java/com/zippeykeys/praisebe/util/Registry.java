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
import com.zippeykeys.praisebe.deity.DeityRegistry;
import com.zippeykeys.praisebe.deity.IDeity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.Builder;
import lombok.val;
import lombok.var;
import net.minecraft.util.ResourceLocation;

public class Registry<T> {
    protected final ImmutableSet<Class<? extends Enum<?>>> classifiers;

    protected final Map<String, T> classes;

    protected final Map<Class<? extends Enum<?>>, Map<Enum<?>, Set<T>>> categorized;

    private final Class<T> dataType;

    @Builder
    @SafeVarargs
    @Contract("_, _ -> new")
    @SuppressWarnings("unchecked")
    public static @NotNull <T> Registry<T> of(Class<T> clazzT, Class<? extends Enum<?>>... classifiers) {
        if (clazzT == IDeity.class)
            return (Registry<T>) new DeityRegistry();
        return new Registry<>(clazzT, classifiers);
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public Registry(Class<T> clazzT, Class<? extends Enum<?>>... classifiers) {
        dataType = clazzT;
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
        return register(key.toString(), value);
    }

    public T register(String key, T value) {
        val previousValue = classes.put(key, value);
        for (var clazz : classifiers) {
            var type = (Enum) ClassUtil.getFieldValueByClass(value, clazz);
            if (type == null) {
                continue;
            }

            var map = categorized.get(clazz);
            map.get(type).add(value);
        }
        return previousValue;
    }

    public T unregister(ResourceLocation key) {
        return unregister(key.toString());
    }

    public T unregister(String key) {
        val value = classes.remove(key);
        for (var clazz : classifiers) {
            var type = dataType.cast(ClassUtil.getFieldValueByClass(value, clazz));
            if (type == null) {
                continue;
            }

            var map = categorized.get(clazz);
            var set = map.get(type);

            set.remove(value);
        }
        return value;
    }

    public T get(ResourceLocation key) {
        return get(key.toString());
    }

    public T get(String key) {
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

    public void forEach(BiConsumer<? super String, ? super T> action) {
        classes.forEach(action);
    }
}
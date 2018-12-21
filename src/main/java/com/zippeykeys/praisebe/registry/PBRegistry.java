package com.zippeykeys.praisebe.registry;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.util.ClassUtil;

import org.immutables.builder.Builder.Factory;
import org.immutables.value.Value.Style;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import lombok.val;
import lombok.var;
import net.minecraft.util.ResourceLocation;

@Style(depluralize = true, strictBuilder = true)

public class PBRegistry<T> {
    protected final ImmutableSet<Class<? extends Enum<?>>> classifiers;

    protected final Map<String, T> classes;

    protected final Map<Class<? extends Enum<?>>, Map<Enum<?>, Set<T>>> categorized;

    @Factory
    @Contract("_, _ -> new")
    @SuppressWarnings("unchecked")
    public static <T> PBRegistry<T> pBRegistry(Class<T> clazzT, List<Class<? extends Enum<?>>> classifiers) {
        if (clazzT == Deity.class)
            return (PBRegistry<T>) new Deity.Registry();
        return new PBRegistry<>(classifiers);
    }

    @SafeVarargs
    public PBRegistry(Class<? extends Enum<?>>... classifiersIn) {
        this(Arrays.asList(classifiersIn));
    }

    @SuppressWarnings("unchecked")
    public PBRegistry(List<Class<? extends Enum<?>>> classifiersIn) {
        classifiers = ImmutableSet.<Class<? extends Enum<?>>>builder() //
                .addAll(classifiersIn) //
                .build();
        classes = new HashMap<>();
        val builder = ImmutableMap.<Class<? extends Enum<?>>, Map<Enum<?>, Set<T>>>builder();
        for (var clazz : classifiersIn) {
            try {
                builder.put(clazz, EnumMap.class.getConstructor(Class.class) //
                        .newInstance(clazz));
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

    public @Nullable T register(ResourceLocation key, T value) {
        return register(key.toString(), value);
    }

    public @Nullable T register(String key, T value) {
        val previousValue = classes.put(key, value);
        for (var clazz : classifiers) {
            var type = clazz.cast(ClassUtil.getFieldValueByClass(value, clazz));
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
            var type = clazz.cast(ClassUtil.getFieldValueByClass(value, clazz));
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
    public <C extends Enum<C>> T getRandom(C key) {
        val set = getSet(key);
        return ((T[]) set.toArray())[new Random().nextInt(set.size())];
    }

    public <C extends Enum<C>> Set<T> getSet(C key) {
        return ImmutableSet.<T>builder().addAll(categorized.get(key.getClass()).get(key)).build();
    }

    public ImmutableMap<String, T> entries() {
        return ImmutableMap.<String, T>builder().putAll(classes).build();
    }

    public ImmutableSet<String> keySet() {
        return ImmutableSet.<String>builder().addAll(classes.keySet()).build();
    }

    public ImmutableSet<T> values() {
        return ImmutableSet.<T>builder().addAll(classes.values()).build();
    }

    public void forEach(BiConsumer<? super String, ? super T> action) {
        classes.forEach(action);
    }

    public static <T> PBRegistryBuilder<T> builder() {
        return new PBRegistryBuilder<T>();
    }
}
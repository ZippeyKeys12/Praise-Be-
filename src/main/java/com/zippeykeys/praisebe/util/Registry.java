package com.zippeykeys.praisebe.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import lombok.val;
import lombok.var;
import lombok.experimental.ExtensionMethod;
import net.minecraft.util.ResourceLocation;

@ExtensionMethod(ClassUtil.class)
public class Registry<T, C> implements Serializable {
    private static final long serialVersionUID = 3510013522407682579L;

    public final Set<Class<T>> classifiers;

    public final Map<ResourceLocation, C> classes;

    public final Map<Class<T>, Map<T, Set<C>>> categorized;

    @SafeVarargs
    public Registry(Class<T>... classifiers) {
        this.classifiers = ImmutableSet.<Class<T>>builder().add(classifiers).build();
        classes = new HashMap<>();
        val builder = ImmutableMap.<Class<T>, Map<T, Set<C>>>builder();
        for (var clazz : classifiers)
            builder.put(clazz, new HashMap<>());
        categorized = builder.build();
    }

    @SuppressWarnings("unchecked")
    public C register(ResourceLocation key, C value) {
        val previousValue = classes.put(key, value);
        for (var clazz : classifiers) {
            try {
                var type = (T) value.getClass().getMethod("get" + clazz.getSimpleName()).invoke(value);
                if (type == null) {
                    continue;
                }

                var map = categorized.get(clazz);
                if (map.containsKey(type)) {
                    map.get(type).add(value);
                } else {
                    map.put(type, new HashSet<C>() {
                        private static final long serialVersionUID = 2184164362052827748L;

                        {
                            add(value);
                        }
                    });
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                continue;
            }
        }
        return previousValue;
    }

    @SuppressWarnings("unchecked")
    public C unregister(ResourceLocation key) {
        val value = classes.remove(key);
        for (var clazz : classifiers) {
            try {
                var type = (T) value.getClass().getMethod("get" + clazz.getSimpleName()).invoke(value);
                if (type == null) {
                    continue;
                }

                var map = categorized.get(clazz);
                var set = map.get(type);

                set.remove(value);
                if (set.isEmpty()) {
                    map.remove(type);
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                continue;
            }
        }
        return value;
    }

    public C get(String key) {
        return get(new ResourceLocation(key));
    }

    public C get(ResourceLocation key) {
        return classes.get(key);
    }

    @SuppressWarnings("unchecked")
    public C getRandom(T key) {
        val set = getSet(key);
        return (C) set.toArray()[new Random().nextInt(set.size())];
    }

    public Set<C> getSet(T key) {
        return ImmutableSet.<C>builder().addAll(categorized.get(key.getClass()).get(key)).build();
    }

    public void forEach(BiConsumer<? super ResourceLocation, ? super C> action) {
        classes.forEach(action);
    }
}
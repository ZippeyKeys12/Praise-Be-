package com.zippeykeys.praisebe.common.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import com.zippeykeys.praisebe.common.deity.IDeity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeityRegistry {
    private static final Map<String, IDeity> DEITIES = new HashMap<>();

    @Contract(" -> new")
    public static @NotNull Map<String, IDeity> get() {
        return new HashMap<>(DEITIES);
    }

    @Contract(pure = true)
    public static @NotNull Set<String> keys() {
        return DEITIES.keySet();
    }

    public static void addDeity(IDeity deity, String id) {
        DEITIES.put(id, deity);
    }

    public static void removeDeity(String id) {
        DEITIES.remove(id);
    }

    @Contract("null -> null")
    public static @Nullable IDeity getDeity(String id) {
        if (id == null || id.isEmpty())
            return null;
        return DEITIES.get(id);
    }

    public static void forEach(BiConsumer<? super String, ? super IDeity> action) {
        DEITIES.forEach(action);
    }
}

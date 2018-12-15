package com.zippeykeys.praisebe.deity;

import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.util.ResourceLocation;

public class DeityRegistry<C extends IDeity<?, ?, ?>> {
    public Map<ResourceLocation, Class<C>> pantheons;

    public Class<C> put(ResourceLocation key, Class<C> value) {
        return pantheons.put(key, value);
    }

    public Class<C> get(String key) {
        return get(new ResourceLocation(key));
    }

    public Class<C> get(ResourceLocation key) {
        return pantheons.get(key);
    }

    public void forEach(BiConsumer<? super ResourceLocation, ? super Class<C>> action) {
        pantheons.forEach(action);
    }
}
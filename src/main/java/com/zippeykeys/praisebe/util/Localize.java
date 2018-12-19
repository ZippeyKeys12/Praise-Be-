package com.zippeykeys.praisebe.util;

import com.zippeykeys.praisebe.PraiseBe;

import org.jetbrains.annotations.Contract;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public interface Localize extends IStringSerializable {
    @Override
    String getName();

    String getPrefix();

    @Contract(pure = true)
    default String getUnlocalizedName() {
        return getPrefix() + "." + getName();
    }

    @Contract(pure = true)
    default String getLocalizedName() {
        return PraiseBe.PROXY.localize(getUnlocalizedName() + ".name");
    }

    @Contract(pure = true)
    default String getLocalizedDescription() {
        return PraiseBe.PROXY.localize(getUnlocalizedName() + ".desc");
    }

    default ResourceLocation getResource() {
        return Util.getResource(getName());
    }
}
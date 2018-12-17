package com.zippeykeys.praisebe.util;

import com.zippeykeys.praisebe.PraiseBe;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public interface Localize extends IStringSerializable {

    @NotNull
    String getPrefix();

    @Contract(pure = true)
    default @NotNull String getUnlocalizedName() {
        return getPrefix() + "." + getName();
    }

    @Contract(pure = true)
    default @NotNull String getLocalizedName() {
        return PraiseBe.PROXY.localize(getUnlocalizedName() + ".name");
    }

    @Contract(pure = true)
    default @NotNull String getLocalizedDescription() {
        return PraiseBe.PROXY.localize(getUnlocalizedName() + ".desc");
    }

    default ResourceLocation getResource() {
        return Util.getResource(getName());
    }
}
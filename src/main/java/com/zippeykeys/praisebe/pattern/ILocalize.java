package com.zippeykeys.praisebe.pattern;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.util.Util;

import org.jetbrains.annotations.Contract;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public interface ILocalize extends IStringSerializable {
    @Override
    String getName();

    String getPrefix();

    @Contract(pure = true)
    default String getUnlocalizedName() {
        return getPrefix() + "." + getName();
    }

    @Contract(pure = true)
    default String getLocalizedName() {
        return Reference.INSTANCE.proxy().localize(getUnlocalizedName() + ".name");
    }

    @Contract(pure = true)
    default String getLocalizedDescription() {
        return Reference.INSTANCE.proxy().localize(getUnlocalizedName() + ".desc");
    }

    default ResourceLocation getResource() {
        return Util.getResource(getName());
    }
}
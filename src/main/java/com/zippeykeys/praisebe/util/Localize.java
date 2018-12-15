package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Localize {
    @NotNull
    String getName();

    @NotNull
    @Contract(pure = true)
    String getUnlocalizedName();

    @NotNull
    @Contract(pure = true)
    String getUnlocalizedDescription();
}
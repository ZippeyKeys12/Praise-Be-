package com.zippeykeys.praisebe.compat;

import com.zippeykeys.praisebe.util.Localize;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EMod implements Localize {
    ;

    @Getter(onMethod_ = @Override)
    private final String name;

    @Override
    @Contract(pure = true)
    public @NotNull String getPrefix() {
        return "mod";
    }
}
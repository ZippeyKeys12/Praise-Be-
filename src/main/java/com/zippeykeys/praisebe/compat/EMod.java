package com.zippeykeys.praisebe.compat;

import com.zippeykeys.praisebe.util.Localize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EMod implements Localize {
    ;

    @Getter(onMethod_ = @Override)
    private final String name;

    @Override
    public String getPrefix() {
        return "mod";
    }
}
package com.zippeykeys.praisebe.block;

import com.zippeykeys.praisebe.util.Localize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EOreBlock implements Localize {
    // Normal //
    GALLIUM("gallium"), //
    PLATINUM("platinum"), //
    TITANIUM("titanium"), //
    TUNGSTEN("tungsten"), //
    CHROMIUM("chromium"), //

    // Enchanted //
    GALVORN("galvorn"), //
    MITHRIL("mithril"), //
    ORICHALCUM("orichalcum"), //
    ADAMANTITE("adamantite"), //
    SCARLETITE("scarletite");

    @Getter(onMethod_ = @Override)
    private String name;

    @Override
    public String getPrefix() {
        return "building";
    }
}
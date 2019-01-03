package com.zippeykeys.praisebe.block;

import com.zippeykeys.praisebe.iface.ILocalize;

import org.jetbrains.annotations.Contract;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum EBuildingBlock implements ILocalize{
    MARBLE("marble"),
    BASALT("basalt");

    @Getter(onMethod_ = @Override)
    private String name;

    @Override
    @Contract(pure = true)
    public String getPrefix(){
        return "building";
    }
}
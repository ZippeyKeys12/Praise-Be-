package com.zippeykeys.praisebe.compat;

import com.zippeykeys.praisebe.iface.ILocalize;

import org.jetbrains.annotations.Contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

import net.minecraftforge.fml.common.Loader;


@AllArgsConstructor
public enum EMod implements ILocalize{
    ;

    @Getter(onMethod_ = @Override)
    private final String name;

    @Override
    @Contract(pure = true)
    public String getPrefix(){
        return "mod";
    }

    public boolean exists(){
        return Loader.isModLoaded(name);
    }
}
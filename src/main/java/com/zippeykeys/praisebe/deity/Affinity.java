package com.zippeykeys.praisebe.deity;

import com.zippeykeys.praisebe.iface.ILocalize;
import com.zippeykeys.praisebe.util.Util;

import org.immutables.value.Value.Immutable;

import net.minecraftforge.registries.IForgeRegistryEntry;

@Immutable
public abstract class Affinity extends IForgeRegistryEntry.Impl<Affinity> implements ILocalize {
    {
        setRegistryName(Util.getResource(getName()));
    }

    @Override
    public abstract String getName();

    public abstract Deity getPrimaryDeity();

    public abstract Deity getSecondaryDeity();

    @Override
    public String getPrefix() {
        return "deity.affinity";
    }
}
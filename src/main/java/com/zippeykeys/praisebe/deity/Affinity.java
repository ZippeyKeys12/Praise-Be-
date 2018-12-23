package com.zippeykeys.praisebe.deity;

import com.zippeykeys.praisebe.iface.ILocalize;
import com.zippeykeys.praisebe.util.Util;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;
import org.immutables.value.Value.Style.ImplementationVisibility;
import org.jetbrains.annotations.Contract;

import lombok.val;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Style(visibility = ImplementationVisibility.PACKAGE, overshadowImplementation = true, depluralize = true, strictBuilder = true)

@Immutable
public abstract class Affinity extends IForgeRegistryEntry.Impl<Affinity> implements ILocalize {
    @Override
    public abstract String getName();

    public abstract Deity getPrimaryDeity();

    public abstract Deity getSecondaryDeity();

    @Override
    public String getPrefix() {
        return "deity.affinity";
    }

    @Contract(" -> new")
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ImmutableAffinity.Builder {
        @Override
        public Affinity build() {
            val result = super.build();
            result.setRegistryName(Util.getResource(result.getName()));
            return result;
        }
    }
}
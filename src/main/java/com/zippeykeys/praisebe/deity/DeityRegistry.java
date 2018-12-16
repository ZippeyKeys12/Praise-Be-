package com.zippeykeys.praisebe.deity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import com.zippeykeys.praisebe.util.Registry;
import com.zippeykeys.praisebe.util.Util;

public class DeityRegistry extends Registry<IDeity> {
    public DeityRegistry() {
        super(IDeity.class, IDeity.Type.class, IDeity.Element.class, IDeity.Alignment.class);
    }

    public IDeity[] registerAll(IDeity... values) {
        return Arrays.stream(values).map(this::register).filter(Objects::nonNull).toArray(IDeity[]::new);
    }

    public IDeity[] registerAll(Collection<? extends IDeity> values) {
        return values.stream().map(this::register).filter(Objects::nonNull).toArray(IDeity[]::new);
    }

    public IDeity register(IDeity value) {
        return register(Util.getResource(value.getName()), value);
    }
}
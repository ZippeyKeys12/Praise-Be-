package com.zippeykeys.praisebe.deity;

import java.util.Arrays;
import java.util.Objects;

import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Registry;
import com.zippeykeys.praisebe.util.Util;

public class DeityRegistry extends Registry<Localize, IDeity> {
    public DeityRegistry() {
        super(Localize.class, IDeity.class, IDeity.Type.class, IDeity.Element.class, IDeity.Alignment.class);
    }

    public IDeity[] registerAll(IDeity... values) {
        return Arrays.stream(values).map(this::register).filter(Objects::nonNull).toArray(IDeity[]::new);
    }

    public IDeity register(IDeity value) {
        return register(Util.getResource(value.getName()), value);
    }
}
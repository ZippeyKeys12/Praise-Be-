package com.zippeykeys.praisebe.deity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import com.zippeykeys.praisebe.util.Registry;
import com.zippeykeys.praisebe.util.Util;

public class DeityRegistry extends Registry<IDeity> {
    public static final DeityRegistry INSTANCE = new DeityRegistry();

    public DeityRegistry() {
        super(IDeity.class, IDeity.Type.class, IDeity.Element.class, IDeity.Alignment.class);
    }

    public IDeity register(IDeity value) {
        return register(Util.getResource(value.getName()), value);
    }

    public IDeity[] registerAll(IDeity... values) {
        return registerAll(Arrays.stream(values));
    }

    public IDeity[] registerAll(Collection<? extends IDeity> values) {
        return registerAll(values.stream());
    }

    public IDeity[] registerAll(Stream<? extends IDeity> values) {
        return values.map(this::register)//
                .filter(Objects::nonNull)//
                .toArray(IDeity[]::new);
    }
}
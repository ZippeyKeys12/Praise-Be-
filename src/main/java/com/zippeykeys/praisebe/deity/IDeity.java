package com.zippeykeys.praisebe.deity;

import com.zippeykeys.praisebe.util.Localize;

import org.jetbrains.annotations.NotNull;

public interface IDeity<T extends Enum<T> & Localize, E extends Enum<E> & Localize, A extends Enum<A> & Localize>
        extends Localize {
    @NotNull
    T getType();

    @NotNull
    E getElement();

    @NotNull
    A getAlignment();

    interface Type extends Localize {

    }
}
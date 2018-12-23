package com.zippeykeys.praisebe.data;

import org.immutables.value.Value.Immutable;

@Immutable
public interface WorldDataSet {
    DeityRegard getRegard();

    PlayerAttributes getAttributes();
}
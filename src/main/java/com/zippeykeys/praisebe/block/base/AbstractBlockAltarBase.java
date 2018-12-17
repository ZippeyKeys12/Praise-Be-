package com.zippeykeys.praisebe.block.base;

import com.zippeykeys.praisebe.deity.Deity.Type;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public abstract class AbstractBlockAltarBase extends AbstractBlockEnum<Type> {
    public AbstractBlockAltarBase() {
        super("altar", Material.ROCK, Type.class);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setHarvestLevel("pickaxe", 1);
        setSoundType(SoundType.STONE);
    }
}
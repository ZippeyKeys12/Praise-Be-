package com.zippeykeys.praisebe.block.base;

import com.zippeykeys.praisebe.deity.Deity.Type;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAltarBase extends BlockEnum<Type> {
    public BlockAltarBase(String nameIn, Material materialIn, CreativeTabs... creativeTabs) {
        super(nameIn, materialIn, Type.class, creativeTabs);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setHarvestLevel("pickaxe", 1);
        setSoundType(SoundType.STONE);
    }
}
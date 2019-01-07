package com.zippeykeys.praisebe.block.base

import com.zippeykeys.praisebe.block.tile.base.PBTileEntity
import com.zippeykeys.praisebe.deity.Deity.Type
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs


class BlockAltarBase(nameIn: String, materialIn: Material,
        tileClass: Class<out PBTileEntity>? = null, creativeTab: CreativeTabs? = null) :
        BlockEnum<Type>(nameIn, materialIn, Type::class.java, tileClass, "type", creativeTab) {
    init {
        setHardness(1.5f)
        setResistance(6000000.0f)
        setHarvestLevel("pickaxe", 1)
        soundType = SoundType.STONE
    }
}
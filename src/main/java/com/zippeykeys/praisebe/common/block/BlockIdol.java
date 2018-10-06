package com.zippeykeys.praisebe.common.block;

import com.zippeykeys.praisebe.common.PraiseBe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockIdol extends Block{
    public BlockIdol(){
        super(Material.ROCK);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setUnlocalizedName(PraiseBe.MODID + ".idol");
    }
}

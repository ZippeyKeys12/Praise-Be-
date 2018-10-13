package com.zippeykeys.praisebe.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;


public interface IPBBlock{
    default ItemBlock getItem(){
        return new ItemBlock((Block) this);
    }
}

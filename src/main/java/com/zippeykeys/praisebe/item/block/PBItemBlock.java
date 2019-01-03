package com.zippeykeys.praisebe.item.block;

import com.zippeykeys.praisebe.block.base.PBBlock;
import com.zippeykeys.praisebe.iface.ILocalize;

import lombok.Getter;

import net.minecraft.item.ItemBlock;


public class PBItemBlock extends ItemBlock implements ILocalize{
    @Getter(onMethod_ = @Override)
    protected final String name;

    public PBItemBlock(PBBlock blockIn){
        this(blockIn, blockIn.getName());
    }

    public PBItemBlock(PBBlock blockIn, String nameIn){
        super(blockIn);
        this.name = nameIn;
    }

    @Override
    public String getPrefix(){
        return "item";
    }
}
package com.zippeykeys.praisebe.item.block;

import com.zippeykeys.praisebe.block.base.PBBlock;
import com.zippeykeys.praisebe.util.Localize;

import lombok.Getter;
import net.minecraft.item.ItemBlock;

public class PBItemBlock extends ItemBlock implements Localize {
    @Getter(onMethod_ = @Override)
    protected final String name;

    public PBItemBlock(PBBlock block) {
        this(block, block.getName());
    }

    public PBItemBlock(PBBlock block, String name) {
        super(block);
        this.name = name;
    }

    @Override
    public String getPrefix() {
        return "item";
    }
}
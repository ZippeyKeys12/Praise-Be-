package com.zippeykeys.praisebe.block;

import java.util.Objects;

import com.zippeykeys.praisebe.tileentity.AbstractPBTileEntity;
import com.zippeykeys.praisebe.util.BlockUtil;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public abstract class AbstractPBBlock extends BlockContainer implements Localize {
    protected AbstractPBBlock() {
        this(Material.ROCK);
    }

    protected AbstractPBBlock(Material materialIn) {
        this(materialIn, materialIn.getMaterialMapColor());
    }

    protected AbstractPBBlock(Material materialIn, MapColor color) {
        super(materialIn, color);
        setRegistryName(getResource());
        setUnlocalizedName(Reference.MOD_ID + "." + Objects.requireNonNull(getRegistryName()).getResourcePath());
        setCreativeTab(Reference.TAB_GENERAL);
    }

    public Item getItem() {
        return BlockUtil.itemFromBlock(this);
    }

    public abstract Class<? extends AbstractPBTileEntity> getTileEntity();
}
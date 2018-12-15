package com.zippeykeys.praisebe.block;

import com.zippeykeys.praisebe.util.BlockUtil;
import com.zippeykeys.praisebe.util.Reference;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractPBBlock extends BlockContainer {
    protected AbstractPBBlock() {
        this(Material.ROCK);
    }

    protected AbstractPBBlock(Material materialIn) {
        this(materialIn, materialIn.getMaterialMapColor());
    }

    protected AbstractPBBlock(Material materialIn, MapColor color) {
        super(materialIn, color);
        setRegistryName(getResource());
        setUnlocalizedName(Reference.MOD_ID + "." + getRegistryName().getResourcePath());
        setCreativeTab(Reference.TAB_GENERAL);
    }

    public ResourceLocation getResource() {
        return new ResourceLocation(Reference.MOD_ID, id());
    }

    public Item getItem() {
        return BlockUtil.itemFromBlock(this);
    }

    public abstract Class<? extends TileEntity> getTileEntity();

    public abstract String id();
}
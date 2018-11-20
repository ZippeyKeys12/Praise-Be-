package com.zippeykeys.praisebe.common.block;

import com.zippeykeys.praisebe.PraiseBe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public abstract class PBBlock extends BlockContainer
{
    protected PBBlock(Material materialIn)
    {
        this(materialIn, materialIn.getMaterialMapColor());
    }

    protected PBBlock(Material materialIn, MapColor color)
    {
        super(materialIn, color);
        setUnlocalizedName(PraiseBe.MOD_ID + "." + id());
        setRegistryName(getResource());
    }

    public ResourceLocation getResource()
    {
        return new ResourceLocation(PraiseBe.MOD_ID, id());
    }

    public Item getItem()
    {
        return new ItemBlock(this).setRegistryName(getResource());
    }

    public abstract Class<? extends TileEntity> getTileEntity();

    public abstract String id();
}

package com.zippeykeys.praisebe.block.base;

import java.util.Objects;

import com.zippeykeys.praisebe.block.tile.base.AbstractPBTileEntity;
import com.zippeykeys.praisebe.util.BlockUtil;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;

import org.jetbrains.annotations.NotNull;

import lombok.val;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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

    public TileEntity createNewTileEntity(@NotNull World worldIn, int meta) {
        val tile = getTileEntity();
        if (tile != null) {
            try {
                return tile.newInstance();
            } catch (InstantiationException | IllegalAccessException ignored) {
            }
        }
        return null;
    }

    public abstract Class<? extends AbstractPBTileEntity> getTileEntity();
}
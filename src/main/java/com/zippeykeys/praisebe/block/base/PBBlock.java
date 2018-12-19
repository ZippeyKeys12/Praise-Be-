package com.zippeykeys.praisebe.block.base;

import java.util.Objects;

import com.zippeykeys.praisebe.block.tile.base.PBTileEntity;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;
import com.zippeykeys.praisebe.util.RegistryUtil;

import org.jetbrains.annotations.Nullable;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import lombok.Getter;
import lombok.val;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PBBlock extends BlockContainer implements Localize {
    @Getter(onMethod_ = @Override)
    protected final String name;

    public PBBlock(String nameIn) {
        this(nameIn, Material.ROCK);
    }

    public PBBlock(String nameIn, Material materialIn) {
        this(nameIn, materialIn, materialIn.getMaterialMapColor());
    }

    public PBBlock(String nameIn, Material materialIn, MapColor color) {
        super(materialIn, color);
        name = nameIn;
        setRegistryName(getResource());
        setUnlocalizedName(Reference.MOD_ID + "." + Objects.requireNonNull(getRegistryName()).getResourcePath());
        setCreativeTab(Reference.TAB_GENERAL);
    }

    @Override
    public String getPrefix() {
        return "tile";
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        val tile = getTileEntity();
        if (tile != null) {
            try {
                return tile.newInstance();
            } catch (InstantiationException | IllegalAccessException ignored) {
            }
        }
        return null;
    }

    public ItemBlock getItem() {
        return RegistryUtil.transferRegistryName(new ItemBlock(this), this);
    }

    public void gatherVariants(Int2ObjectMap<? super String> variants) {
        variants.put(0, "inventory");
    }

    public @Nullable Class<? extends PBTileEntity> getTileEntity() {
        return null;
    }
}
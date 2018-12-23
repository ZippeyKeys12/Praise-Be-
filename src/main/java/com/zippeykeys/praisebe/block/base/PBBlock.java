package com.zippeykeys.praisebe.block.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.block.tile.base.PBTileEntity;
import com.zippeykeys.praisebe.iface.ILocalize;
import com.zippeykeys.praisebe.util.RegistryUtil;

import org.immutables.builder.Builder.Factory;
import org.jetbrains.annotations.Nullable;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Getter;
import lombok.val;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class PBBlock extends BlockContainer implements ILocalize {
    @Getter(onMethod_ = @Override)
    protected final String name;

    @Factory
    public static PBBlock block(String name, Material material, Optional<MapColor> color,
            CreativeTabs... creativeTabs) {
        return new PBBlock(name, material, color.orElse(material.getMaterialMapColor()), creativeTabs);
    }

    public PBBlock(String nameIn, Material materialIn) {
        this(nameIn, materialIn, materialIn.getMaterialMapColor());
    }

    public PBBlock(String nameIn, Material materialIn, CreativeTabs... creativeTabs) {
        this(nameIn, materialIn, materialIn.getMaterialMapColor(), creativeTabs);
    }

    public PBBlock(String nameIn, Material materialIn, MapColor color, CreativeTabs... creativeTabs) {
        super(materialIn, color);
        name = nameIn;
        setRegistryName(getResource());
        setUnlocalizedName(Reference.MOD_ID + "." + getRegistryName().getResourcePath());
        Arrays.stream(creativeTabs) //
                .filter(Objects::nonNull) //
                .forEach(this::setCreativeTab);
    }

    @Override
    public String getPrefix() {
        return "tile";
    }

    @Override
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

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public ItemBlock getItem() {
        return RegistryUtil.transferRegistryName(new ItemBlock(this), this);
    }

    public Int2ObjectMap<String> getVariants() {
        val variants = new Int2ObjectOpenHashMap<String>();
        variants.put(0, "inventory");
        return variants;
    }

    public @Nullable Class<? extends PBTileEntity> getTileEntity() {
        return null;
    }

    public static BlockBuilder builder() {
        return new BlockBuilder();
    }
}
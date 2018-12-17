package com.zippeykeys.praisebe.block.base;

import com.zippeykeys.praisebe.block.tile.base.AbstractPBTileEntity;
import com.zippeykeys.praisebe.item.block.ItemBlockEnum;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public abstract class AbstractBlockEnum<T extends Enum<T> & IStringSerializable> extends AbstractPBBlock {
    private final String name;

    private final T[] values;

    private final PropertyEnum<T> property;

    @Contract(pure = true)
    public static @NotNull <T extends Enum<T> & IStringSerializable> AbstractBlockEnum<T> of(String name,
            Material materialIn, Class<T> clazz, Class<? extends AbstractPBTileEntity> tileClass) {
        return of(name, materialIn, clazz, tileClass, "type");
    }

    @Contract(value = "_, _, _, _, _ -> new", pure = true)
    public static @NotNull <T extends Enum<T> & IStringSerializable> AbstractBlockEnum<T> of(String name,
            Material materialIn, Class<T> clazz, Class<? extends AbstractPBTileEntity> tileClass, String propertyName) {
        return new AbstractBlockEnum<T>(name, materialIn, clazz, propertyName) {
            @Override
            public Class<? extends AbstractPBTileEntity> getTileEntity() {
                return tileClass;
            }
        };
    }

    public AbstractBlockEnum(String name, Material materialIn, Class<T> clazz) {
        this(name, materialIn, clazz, "type");
    }

    public AbstractBlockEnum(String name, Material materialIn, @NotNull Class<T> clazz, String propertyName) {
        super(materialIn);
        this.name = name;
        values = clazz.getEnumConstants();
        property = PropertyEnum.create(propertyName, clazz);
        setDefaultState(blockState.getBaseState());
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull String getPrefix() {
        return "tile";
    }

    @Override
    protected @NotNull BlockStateContainer createBlockState() {
        return new BlockStateContainer.Builder(this) //
                .build();
    }

    @Override
    public @NotNull IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(property, values[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(property).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> subBlocks) {
        for (T value : values)
            subBlocks.add(new ItemStack(this, 1, value.ordinal()));
    }

    protected BlockStateContainer createStateContainer() {
        return new BlockStateContainer.Builder(this) //
                .add(property) //
                .build();
    }

    @Override
    public ItemBlock getItem() {
        return new ItemBlockEnum<>(this);
    }

    public T[] getValues() {
        return values;
    }
}
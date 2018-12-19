package com.zippeykeys.praisebe.block.base;

import com.zippeykeys.praisebe.block.tile.base.PBTileEntity;
import com.zippeykeys.praisebe.item.block.ItemBlockEnum;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.RegistryUtil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockEnum<T extends Enum<T> & Localize> extends PBBlock {
    protected final T[] values;

    protected final PropertyEnum<T> property;

    @Contract(pure = true)
    public static @NotNull <T extends Enum<T> & Localize> BlockEnum<T> of(String name, Material materialIn,
            Class<T> clazz, Class<? extends PBTileEntity> tileClass) {
        return of(name, materialIn, clazz, tileClass, "type");
    }

    @Contract(value = "_, _, _, _, _ -> new", pure = true)
    public static @NotNull <T extends Enum<T> & Localize> BlockEnum<T> of(String name, Material materialIn,
            Class<T> clazz, Class<? extends PBTileEntity> tileClass, String propertyName) {
        return new BlockEnum<T>(name, materialIn, clazz, propertyName) {
            @Override
            public Class<? extends PBTileEntity> getTileEntity() {
                return tileClass;
            }
        };
    }

    public BlockEnum(String nameIn, Material materialIn, Class<T> clazz) {
        this(nameIn, materialIn, clazz, "type");
    }

    public BlockEnum(String nameIn, Material materialIn, @NotNull Class<T> clazz, String propertyName) {
        super(nameIn, materialIn);
        values = clazz.getEnumConstants();
        property = PropertyEnum.create(propertyName, clazz);
        setDefaultState(blockState.getBaseState());
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

    @Override
    public ItemBlock getItem() {
        return RegistryUtil.transferRegistryName(new ItemBlockEnum<>(this), this);
    }

    protected BlockStateContainer createStateContainer() {
        return new BlockStateContainer.Builder(this) //
                .add(property) //
                .build();
    }

    public T[] getValues() {
        return values;
    }
}
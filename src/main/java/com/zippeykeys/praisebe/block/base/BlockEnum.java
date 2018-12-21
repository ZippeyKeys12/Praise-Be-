package com.zippeykeys.praisebe.block.base;

import java.util.Optional;

import com.zippeykeys.praisebe.block.tile.base.PBTileEntity;
import com.zippeykeys.praisebe.item.block.ItemBlockEnum;
import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.RegistryUtil;

import org.immutables.builder.Builder.Factory;
import org.immutables.builder.Builder.Parameter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.val;
import lombok.var;
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

    protected final PropertyEnum<T> DATA_PROPERTY;

    protected final BlockStateContainer newBlockState;

    @Factory
    @Contract(value = "_, _, _, _, _, _ -> new", pure = true)
    public static <T extends Enum<T> & Localize> BlockEnum<T> blockEnum(String name, Material material,
            @Parameter Class<T> clazz, Optional<Class<? extends PBTileEntity>> tileClass, Optional<String> propertyName,
            CreativeTabs... creativeTabs) {
        return new BlockEnum<T>(name, material, clazz, propertyName.orElse("type"), creativeTabs) {
            @Override
            public @Nullable Class<? extends PBTileEntity> getTileEntity() {
                return tileClass.orElse(null);
            }
        };
    }

    public BlockEnum(String nameIn, Material materialIn, Class<T> clazz) {
        this(nameIn, materialIn, clazz, "type");
    }

    public BlockEnum(String nameIn, Material materialIn, Class<T> clazz, CreativeTabs... creativeTabs) {
        this(nameIn, materialIn, clazz, "type", creativeTabs);
    }

    public BlockEnum(String nameIn, Material materialIn, Class<T> clazz, String propertyName,
            CreativeTabs... creativeTabs) {
        super(nameIn, materialIn, creativeTabs);
        DATA_PROPERTY = PropertyEnum.create(propertyName, clazz);
        newBlockState = new BlockStateContainer.Builder(this) //
                .add(DATA_PROPERTY) //
                .build();
        values = clazz.getEnumConstants();
        setDefaultState(getBlockState().getBaseState());
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this);
    }

    @Override
    public final BlockStateContainer getBlockState() {
        return newBlockState;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(DATA_PROPERTY, values[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(DATA_PROPERTY).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> subBlocks) {
        for (var value : values) {
            subBlocks.add(new ItemStack(this, 1, value.ordinal()));
        }
    }

    @Override
    public ItemBlock getItem() {
        return RegistryUtil.transferRegistryName(new ItemBlockEnum<>(this), this);
    }

    @Override
    public Int2ObjectMap<String> getVariants() {
        val variants = new Int2ObjectOpenHashMap<String>();
        for (var i = 0; i < values.length; i++) {
            variants.put(i, DATA_PROPERTY.getName() + "=" + values[i].name());
        }
        return variants;
    }

    protected BlockStateContainer createStateContainer() {
        return new BlockStateContainer.Builder(this) //
                .add(DATA_PROPERTY) //
                .build();
    }

    public T[] getValues() {
        return values;
    }

    public static <C extends Enum<C> & Localize> BlockEnumBuilder<C> builder(Class<C> clazz) {
        return new BlockEnumBuilder<C>(clazz);
    }
}
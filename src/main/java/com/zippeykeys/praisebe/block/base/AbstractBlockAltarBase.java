package com.zippeykeys.praisebe.block.base;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public abstract class AbstractBlockAltarBase extends AbstractPBBlock {
    public AbstractBlockAltarBase() {
        super(Material.ROCK);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setHarvestLevel("pickaxe", 1);
        setSoundType(SoundType.STONE);
    }

    @Getter(onMethod_ = @Override)
    private final String name = "altar";

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean causesSuffocation(IBlockState state) {
        return true;
    }

    @Override
    public @NotNull EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
package com.zippeykeys.praisebe.block.multi;

import com.zippeykeys.praisebe.factory.MultiblockPartBuilder;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import lombok.Getter;
import lombok.experimental.Wither;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class MultiblockPart implements Cloneable{
    @Getter
    protected BlockPos pos;

    @Getter
    @Wither
    protected final IBlockState blockState;

    @Getter
    @Wither
    protected final TileEntity tileEntity;

    public MultiblockPart(BlockPos posIn, IBlockState blockStateIn){
        this(posIn, blockStateIn, null);
    }

    public MultiblockPart(BlockPos posIn, IBlockState blockStateIn, @Nullable TileEntity tileEntityIn){
        pos = posIn;
        blockState = blockStateIn;
        tileEntity = tileEntityIn;
    }

    public boolean is(World world, BlockPos posIn){
        return world.getBlockState(pos) == blockState;
    }

    public void rotate(){
        pos = new BlockPos(-pos.getY(), pos.getX(), pos.getZ());
    }

    @Override
    public MultiblockPart clone(){
        return new MultiblockPart(pos, blockState, tileEntity);
    }

    @Contract(" -> new")
    public static MultiblockPartBuilder builder(){
        return new MultiblockPartBuilder();
    }
}
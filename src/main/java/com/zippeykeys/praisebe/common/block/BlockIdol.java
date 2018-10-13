package com.zippeykeys.praisebe.common.block;

import com.zippeykeys.praisebe.common.PraiseBe;
import com.zippeykeys.praisebe.common.tileentity.TileIdol;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class BlockIdol extends BlockContainer implements IPBBlock{
    public BlockIdol(){
        super(Material.ROCK);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setUnlocalizedName(PraiseBe.MODID + ".idol");
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos){
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        TileEntity self = (TileEntity) worldIn.getTileEntity(pos);
        if(self == null || playerIn.isSneaking())
            return false;
        worldIn.notifyBlockUpdate(pos, state, state, 3);
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state){
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileIdol();
    }
}

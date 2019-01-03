package com.zippeykeys.praisebe.block.base;

import com.zippeykeys.praisebe.block.tile.base.TileEntityIdolBase;

import org.jetbrains.annotations.Nullable;

import lombok.val;
import lombok.var;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockIdolBase extends PBBlock{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockIdolBase(String nameIn, Material materialIn){
        super(nameIn, materialIn);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setHarvestLevel("pickaxe", 1);
        setDefaultState(blockState.getBaseState()
          .withProperty(FACING, EnumFacing.NORTH));
        setSoundType(SoundType.STONE);
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
      float hitZ, int meta, EntityLivingBase placer, EnumHand hand){
        return getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
        var facing = EnumFacing.NORTH;
        val tile = worldIn.getTileEntity(pos);
        val tileClazz = getTileEntity();
        if(tileClazz != null && tileClazz.isInstance(tile)){
            facing = EnumFacing.getFront(tileClazz.cast(tile)
              .getFacing());
        }
        return state.withProperty(FACING, facing);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        var enumFacing = EnumFacing.getFront(meta);
        if(enumFacing.getAxis() == EnumFacing.Axis.Y){
            enumFacing = EnumFacing.NORTH;
        }
        return getDefaultState().withProperty(FACING, enumFacing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(FACING)
          .getIndex();
    }

    @Override
    public int damageDropped(IBlockState state){
        return getMetaFromState(state);
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos){
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
      EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        val self = worldIn.getTileEntity(pos);
        if(self == null || playerIn.isSneaking()){ return false; }
        worldIn.notifyBlockUpdate(pos, state, state, 3);
        return true;
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer.Builder(this) //
          .add(FACING) //
          .build();
    }

    @Override
    public @Nullable Class<? extends TileEntityIdolBase> getTileEntity(){
        return null;
    }
}
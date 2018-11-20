package com.zippeykeys.praisebe.common.block;

import com.zippeykeys.praisebe.PraiseBe;
import com.zippeykeys.praisebe.common.tileentity.TileIdol;

import org.jetbrains.annotations.NotNull;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockIdol extends PBBlock {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockIdol() {
        super(Material.ROCK);
        setHardness(1.5f);
        setResistance(6000000.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(PraiseBe.CREATIVE_TAB);
        setHarvestLevel("pickaxe", 0);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public String id() {
        return "idol";
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity self = worldIn.getTileEntity(pos);
        if (self == null || playerIn.isSneaking())
            return false;
        worldIn.notifyBlockUpdate(pos, state, state, 3);
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(@NotNull World worldIn, int meta) {
        return new TileIdol();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public Class<? extends TileEntity> getTileEntity() {
        return TileIdol.class;
    }

    public enum EDeity {

    }
}

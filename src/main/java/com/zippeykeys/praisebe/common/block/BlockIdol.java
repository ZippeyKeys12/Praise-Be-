package com.zippeykeys.praisebe.common.block;

import com.zippeykeys.praisebe.common.tileentity.TileIdol;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public class BlockIdol extends PBBlock
{
    private final String deityId;

    public BlockIdol()
    {
        this("");
    }

    public BlockIdol(String deityId)
    {
        super(Material.ROCK);
        setHardness(1.5f);
        setResistance(6000000.0F);
        this.deityId = deityId;
    }

    @Override
    public String id()
    {
        return "idol";
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        TileEntity self = worldIn.getTileEntity(pos);
        if(self == null || playerIn.isSneaking())
            return false;
        worldIn.notifyBlockUpdate(pos, state, state, 3);
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(@NotNull World worldIn, int meta)
    {
        return new TileIdol(deityId);
    }

    @Override
    public Class<? extends TileEntity> getTileEntity()
    {
        return TileIdol.class;
    }
}

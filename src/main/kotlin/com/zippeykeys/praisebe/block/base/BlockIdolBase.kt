package com.zippeykeys.praisebe.block.base

import com.zippeykeys.praisebe.block.tile.base.TileEntityIdolBase
import net.minecraft.block.BlockHorizontal
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World


class BlockIdolBase(nameIn: String, materialIn: Material) : PBBlock(nameIn, materialIn) {
    override val tileEntity: Class<out TileEntityIdolBase>?
        get() = null

    init {
        setHardness(1.5f)
        setResistance(6000000.0f)
        setHarvestLevel("pickaxe", 1)
        defaultState = blockState.baseState
                .withProperty(FACING, EnumFacing.NORTH)
        soundType = SoundType.STONE
    }

    override fun getStateForPlacement(world: World, pos: BlockPos, facing: EnumFacing, hitX: Float, hitY: Float,
            hitZ: Float, meta: Int, placer: EntityLivingBase, hand: EnumHand): IBlockState {
        return defaultState.withProperty(FACING, facing)
    }

    @Suppress("OverridingDeprecatedMember")
    override fun getActualState(state: IBlockState, worldIn: IBlockAccess, pos: BlockPos): IBlockState {
        var facing = EnumFacing.NORTH
        val tile = worldIn.getTileEntity(pos)
        val tileClazz = tileEntity
        if (tileClazz != null && tileClazz.isInstance(tile)) {
            facing = EnumFacing.getFront(tileClazz.cast(tile)
                    .facing)
        }
        return state.withProperty(FACING, facing)
    }

    @Suppress("OverridingDeprecatedMember")
    override fun getStateFromMeta(meta: Int): IBlockState {
        var enumFacing = EnumFacing.getFront(meta)
        if (enumFacing.axis == EnumFacing.Axis.Y) {
            enumFacing = EnumFacing.NORTH
        }
        return defaultState.withProperty(FACING, enumFacing)
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return state.getValue(FACING)
                .index
    }

    override fun damageDropped(state: IBlockState): Int {
        return getMetaFromState(state)
    }

    override fun isNormalCube(state: IBlockState, world: IBlockAccess, pos: BlockPos): Boolean {
        return false
    }

    @Suppress("OverridingDeprecatedMember")
    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    @Suppress("OverridingDeprecatedMember")
    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    @Suppress("OverridingDeprecatedMember")
    override fun getRenderType(state: IBlockState): EnumBlockRenderType {
        return EnumBlockRenderType.MODEL
    }

    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer,
            hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        val self = worldIn.getTileEntity(pos)
        if (self == null || playerIn.isSneaking) {
            return false
        }
        worldIn.notifyBlockUpdate(pos, state, state, 3)
        return true
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer.Builder(this)
                .add(FACING)
                .build()
    }

    companion object {
        val FACING = BlockHorizontal.FACING
    }
}
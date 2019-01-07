package com.zippeykeys.praisebe.block.multi

import net.minecraft.block.state.IBlockState
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


open class MultiblockPart constructor(pos: BlockPos,
        val blockState: IBlockState,
        val tileEntity: TileEntity? = null) : Cloneable {
    var pos: BlockPos
        protected set

    init {
        this.pos = pos
    }

    fun `is`(world: World, posIn: BlockPos): Boolean {
        return world.getBlockState(pos) === blockState
    }

    fun rotate() {
        pos = BlockPos(-pos.y, pos.x, pos.z)
    }

    public override fun clone(): MultiblockPart {
        return MultiblockPart(pos, blockState, tileEntity)
    }
}
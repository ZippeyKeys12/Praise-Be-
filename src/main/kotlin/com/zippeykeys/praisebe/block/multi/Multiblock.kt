package com.zippeykeys.praisebe.block.multi

import com.google.common.collect.ImmutableList
import com.zippeykeys.praisebe.iface.ILocalize
import com.zippeykeys.praisebe.util.getResource
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.registries.IForgeRegistryEntry
import org.apache.logging.log4j.util.TriConsumer

class Multiblock(private val actualName: String, val activator: EMBActivator = EMBActivator.values()[0],
        val trigger: IBlockState, private val parts: ImmutableList<MultiblockPart>,
        private val structureBuilder: TriConsumer<Multiblock, World, BlockPos>) :
        IForgeRegistryEntry.Impl<Multiblock>(),
        ILocalize {
    init {
        registryName = getResource(actualName)
    }

    override fun getName(): String {
        return actualName
    }

    override val prefix: String
        get() = "multiblock"

    fun isValid(world: World, pos: BlockPos, player: EntityPlayer): Boolean {
        for (i in 0..3) {
            if (checkStructure(world, pos, player)) {
                return true
            }
            parts.forEach { it.rotate() }
        }
        return false
    }

    operator fun get(pos: BlockPos): MultiblockPart? {
        return parts
                .stream()
                .filter { x -> x.pos === pos }
                .findAny()
                .orElse(null)
    }

    fun checkStructure(world: World, pos: BlockPos, player: EntityPlayer): Boolean {
        return parts
                .stream()
                .allMatch { x -> world.getBlockState(pos.add(x.pos)) == x.blockState }
    }

    fun buildStructure(world: World, blockPos: BlockPos) {
        structureBuilder.accept(this, world, blockPos)
    }
}
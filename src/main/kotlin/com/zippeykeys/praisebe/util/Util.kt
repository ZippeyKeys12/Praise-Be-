package com.zippeykeys.praisebe.util

import com.zippeykeys.praisebe.Reference
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.relauncher.Side


val effectiveSide: Side
    get() = FMLCommonHandler.instance()
            .effectiveSide

fun getLogicalSide(world: World): Side {
    return if (world.isRemote) {
        Side.CLIENT
    } else {
        Side.SERVER
    }
}

fun getResource(resourcePathIn: String): ResourceLocation {
    return ResourceLocation(Reference.MOD_ID, resourcePathIn)
}
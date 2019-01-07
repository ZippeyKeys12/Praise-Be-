package com.zippeykeys.praisebe.util

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraftforge.common.UsernameCache
import net.minecraftforge.fml.common.FMLCommonHandler
import java.util.ArrayList
import java.util.UUID


fun getPlayer(uuid: UUID): EntityPlayer {
    return FMLCommonHandler.instance()
            .minecraftServerInstance.playerList.getPlayerByUUID(uuid)
}

fun getUUID(player: EntityPlayer): UUID {
    return player.gameProfile.id
}

fun getUsername(player: EntityPlayer): String? {
    return getUsername(getUUID(player))
}

fun getUsername(uuid: UUID): String? {
    return UsernameCache.getLastKnownUsername(uuid)
}

@JvmOverloads
fun getBlocksNearby(player: EntityPlayer, world: World,
        clazz: Class<out TileEntity>?, range: Int = 1): List<TileEntity> {
    var tileEntity: TileEntity?
    val tileEntities = ArrayList<TileEntity>()
    for (x in -range..range) {
        for (y in -range..range) {
            for (z in -range..range) {
                tileEntity = world.getTileEntity(player.position.add(x, y, z))
                if (clazz != null) {
                    if (clazz.isInstance(tileEntity)) {
                        if (tileEntity != null) {
                            tileEntities.add(tileEntity)
                        }
                    }
                } else {
                    if (tileEntity != null) {
                        tileEntities.add(tileEntity)
                    }
                }
            }
        }
    }
    return tileEntities
}

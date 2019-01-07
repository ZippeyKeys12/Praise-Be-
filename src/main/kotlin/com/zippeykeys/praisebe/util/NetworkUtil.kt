package com.zippeykeys.praisebe.util

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.data.DeityRegard
import net.minecraft.entity.player.EntityPlayer
import java.util.UUID


private val worldData = Reference.INSTANCE.worldData()

fun getRegard(player: EntityPlayer): DeityRegard {
    return worldData.getDeityRegard(player)
}

fun getRegard(uuid: UUID): DeityRegard {
    return worldData.getDeityRegard(uuid)
}
package com.zippeykeys.praisebe.data

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.util.getUUID
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraft.world.storage.WorldSavedData
import java.util.HashMap
import java.util.UUID


class PBWorldData @JvmOverloads constructor(id: String = ID) : WorldSavedData(id) {

    private val playerData = HashMap<UUID, WorldDataSet>()

    fun ensureExists(player: EntityPlayer) {
        ensureExists(getUUID(player))
    }

    fun ensureExists(uuid: UUID) {
        if (!playerData.containsKey(uuid)) {
            playerData[uuid] = WorldDataSet(
                    regard = DeityRegard(uuid, this),
                    attributes = PlayerAttributes()
            )
        }
    }

    fun getAttributes(player: EntityPlayer): PlayerAttributes {
        return getAttributes(getUUID(player))
    }

    fun getAttributes(uuid: UUID): PlayerAttributes {
        ensureExists(uuid)
        return playerData[uuid]!!.attributes
    }

    fun getDeityRegard(player: EntityPlayer): DeityRegard {
        return getDeityRegard(getUUID(player))
    }

    fun getDeityRegard(uuid: UUID): DeityRegard {
        ensureExists(uuid)
        return playerData[uuid]!!.regard
    }

    override fun readFromNBT(nbt: NBTTagCompound) {
        val regards = nbt.getTagList("praiseBeData", 10)
        for (tag in regards) {
            val tagCompound = tag as NBTTagCompound
            val uuid = tagCompound.getUniqueId("playerID")!!
            val regard = DeityRegard(tagCompound.getCompoundTag("regards"), this)
            val attributes = PlayerAttributes(tagCompound.getCompoundTag("attributes"))
            playerData[uuid] = WorldDataSet(
                    regard = regard,
                    attributes = attributes
            )
        }
    }

    override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound {
        val regards = NBTTagList()
        playerData.forEach { key, value ->
            val tagCompound = NBTTagCompound()
            tagCompound.setUniqueId("playerID", key)
            tagCompound.setTag("regards", value.regard
                    .serializeNBT())
            tagCompound.setTag("attributes", value.attributes
                    .serializeNBT())
            regards.appendTag(tagCompound)
        }
        compound.setTag("praiseBeData", regards)
        return compound
    }

    companion object {
        val ID = Reference.MOD_ID + "_Regards"
    }
}

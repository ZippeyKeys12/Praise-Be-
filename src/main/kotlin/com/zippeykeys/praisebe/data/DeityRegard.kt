package com.zippeykeys.praisebe.data

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.util.getPlayer
import com.zippeykeys.praisebe.util.getUUID
import com.zippeykeys.praisebe.util.getUsername
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.MathHelper.clamp
import net.minecraftforge.common.util.INBTSerializable
import java.util.HashMap
import java.util.UUID


class DeityRegard : INBTSerializable<NBTTagCompound> {
    private var saver: PBWorldData

    var uuid: UUID? = null
        private set

    private val regards = HashMap<String, Double>()

    var player: EntityPlayer
        get() = getPlayer(uuid!!)
        set(player) = setPlayer(getUUID(player))

    val username: String?
        get() = getUsername(uuid!!)

    constructor(nbt: NBTTagCompound, saverIn: PBWorldData) {
        saver = saverIn
        deserializeNBT(nbt)
    }

    constructor(player: EntityPlayer, saverIn: PBWorldData) : this(getUUID(player), saverIn)

    constructor(uuidIn: UUID, saverIn: PBWorldData) {
        uuid = uuidIn
        saver = saverIn
        Reference.INSTANCE
                .deityRegistry()
                .keySet()
                .forEach { this.addRegard(it) }
    }

    fun getSaver(): PBWorldData {
        return saver
    }

    fun setSaver(saverIn: PBWorldData) {
        saver = saverIn
        markDirty()
    }

    fun setPlayer(uuidIn: UUID) {
        uuid = uuidIn
        markDirty()
    }

    operator fun get(deity: ResourceLocation): Double? {
        return get(deity.toString())
    }

    operator fun get(deity: String): Double? {
        return regards[deity]
    }

    fun addRegard(deity: ResourceLocation) {
        addRegard(deity.toString())
    }

    fun addRegard(deity: ResourceLocation, change: Double) {
        addRegard(deity.toString(), change)
    }

    @JvmOverloads
    fun addRegard(deity: String, change: Double = 0.0) {
        regards[deity] = clamp(regards[deity]!! + change, -1.0, 1.0)
    }

    private fun markDirty() {
        saver.markDirty()
    }

    override fun serializeNBT(): NBTTagCompound {
        val tagCompound = NBTTagCompound()
        tagCompound.setUniqueId("uuid", uuid!!)
        val regData = NBTTagList()
        regards.forEach { key, value ->
            val compound = NBTTagCompound()
            compound.setString("name", key)
            compound.setDouble("regard", value)
            regData.appendTag(compound)
        }
        tagCompound.setTag("regards", regData)
        return tagCompound
    }

    override fun deserializeNBT(nbt: NBTTagCompound) {
        uuid = nbt.getUniqueId("uuid")
        val regData = nbt.getTagList("regards", 10)
        regData.forEach { tag ->
            val tagCompound = tag as NBTTagCompound
            regards[tagCompound.getString("name")] = tagCompound.getDouble("regard")
        }
    }
}

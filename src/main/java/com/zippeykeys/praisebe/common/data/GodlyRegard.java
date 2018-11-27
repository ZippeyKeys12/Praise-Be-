package com.zippeykeys.praisebe.common.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.zippeykeys.praisebe.common.registry.DeityRegistry;
import com.zippeykeys.praisebe.common.util.PlayerUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.INBTSerializable;

public class GodlyRegard implements INBTSerializable<NBTTagCompound> {
    private PBWorldData saver;
    private UUID uuid;
    private Map<String, Double> regards = new HashMap<>();

    public GodlyRegard(@NotNull EntityPlayer player, PBWorldData saver) {
        this(player.getUniqueID(), saver);
    }

    GodlyRegard(@NotNull UUID uuid, @Nullable PBWorldData saver) {
        this.uuid = uuid;
        this.saver = saver;
        DeityRegistry.keys().forEach(this::setRegard);
    }

    public PBWorldData getSaver() {
        return saver;
    }

    public void setSaver(PBWorldData saver) {
        this.saver = saver;
        markDirty();
    }

    public UUID getUUID() {
        return uuid;
    }

    public EntityPlayer getPlayer() {
        return PlayerUtil.getPlayer(uuid);
    }

    public void setPlayer(EntityPlayer player) {
        uuid = player.getUniqueID();
        markDirty();
    }

    public double getRegard(String deity) {
        return regards.get(deity);
    }

    public void setRegard(String deity) {
        setRegard(deity, 0);
    }

    public void setRegard(String deity, double change) {
        regards.put(deity, regards.get(deity) + change);
    }

    private void markDirty() {
        saver.markDirty();
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setUniqueId("uuid", uuid);
        NBTTagList regData = new NBTTagList();
        regards.forEach((key, value) -> {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("name", key);
            compound.setDouble("regard", value);
            regData.appendTag(compound);
        });
        tagCompound.setTag("regards", regData);
        return tagCompound;
    }

    @Override
    public void deserializeNBT(@NotNull NBTTagCompound nbt) {
        uuid = nbt.getUniqueId("uuid");
        NBTTagList regData = nbt.getTagList("regards", 10);
        regData.forEach((tag) -> {
            NBTTagCompound tagCompound = (NBTTagCompound) tag;
            if (tagCompound == null)
                return;
            regards.put(tagCompound.getString("name"), tagCompound.getDouble("regard"));
        });
    }
}

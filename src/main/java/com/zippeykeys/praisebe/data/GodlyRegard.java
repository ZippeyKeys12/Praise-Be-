package com.zippeykeys.praisebe.data;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

import com.zippeykeys.praisebe.deity.EModDeities;
import com.zippeykeys.praisebe.util.PlayerUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.var;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.INBTSerializable;

public class GodlyRegard implements INBTSerializable<NBTTagCompound> {
    private PBWorldData saver;
    private UUID uuid;
    private Map<EModDeities, Double> regards = new EnumMap<>(EModDeities.class);

    public GodlyRegard(@NotNull EntityPlayer player, PBWorldData saver) {
        this(player.getUniqueID(), saver);
    }

    GodlyRegard(@NotNull UUID uuid, @Nullable PBWorldData saver) {
        this.uuid = uuid;
        this.saver = saver;
        for (var deity : EModDeities.values()) {
            setRegard(deity);
        }
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
        return regards.get(EModDeities.valueOf(deity));
    }

    public double getRegard(EModDeities deity) {
        return regards.get(deity);
    }

    public void setRegard(String deity) {
        setRegard(deity, 0);
    }

    public void setRegard(String deity, double change) {
        setRegard(EModDeities.valueOf(deity), change);
    }

    public void setRegard(EModDeities deity) {
        setRegard(deity, 0);
    }

    public void setRegard(EModDeities deity, double change) {
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
            compound.setString("name", key.name());
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
            regards.put(EModDeities.valueOf(tagCompound.getString("name")), tagCompound.getDouble("regard"));
        });
    }
}

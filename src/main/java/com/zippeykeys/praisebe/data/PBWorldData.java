package com.zippeykeys.praisebe.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.util.PlayerUtil;

import lombok.var;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.storage.WorldSavedData;

public class PBWorldData extends WorldSavedData {
    public static final String ID = Reference.MOD_ID + "_Regards";

    private Map<UUID, DeityRegard> playerRegards = new HashMap<>();

    public PBWorldData() {
        this(ID);
    }

    public PBWorldData(String id) {
        super(id);
    }

    public DeityRegard getDeityRegard(EntityPlayer player) {
        return getDeityRegard(PlayerUtil.getUUID(player));
    }

    public DeityRegard getDeityRegard(UUID uuid) {
        return playerRegards.get(uuid);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList regards = nbt.getTagList("godlyRegards", 10);
        for (var tag : regards) {
            NBTTagCompound tagCompound = (NBTTagCompound) tag;
            if (tagCompound == null)
                return;
            UUID uuid = tagCompound.getUniqueId("playerID");
            DeityRegard regard = new DeityRegard(Objects.requireNonNull(uuid), this);
            regard.deserializeNBT(tagCompound.getCompoundTag("regards"));
            playerRegards.put(uuid, regard);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagList regards = new NBTTagList();
        playerRegards.forEach((key, value) -> {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setUniqueId("playerID", key);
            tagCompound.setTag("regards", value.serializeNBT());
            regards.appendTag(tagCompound);
        });
        compound.setTag("godlyRegards", regards);
        return compound;
    }
}

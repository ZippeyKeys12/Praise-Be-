package com.zippeykeys.praisebe.data;

import java.util.HashMap;
import java.util.Map;
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

    private Map<UUID, WorldDataSet> playerData = new HashMap<>();

    public PBWorldData() {
        this(ID);
    }

    public PBWorldData(String id) {
        super(id);
    }

    public void ensureExists(EntityPlayer player) {
        ensureExists(PlayerUtil.getUUID(player));
    }

    public void ensureExists(UUID uuid) {
        if (!playerData.containsKey(uuid)) {
            playerData.put(uuid, ImmutableWorldDataSet.builder() //
                    .attributes(new PlayerAttributes()) //
                    .regard(new DeityRegard(uuid, this)) //
                    .build() //
            );
        }
    }

    public PlayerAttributes getAttributes(EntityPlayer player) {
        return getAttributes(PlayerUtil.getUUID(player));
    }

    public PlayerAttributes getAttributes(UUID uuid) {
        ensureExists(uuid);
        return playerData.get(uuid).getAttributes();
    }

    public DeityRegard getDeityRegard(EntityPlayer player) {
        return getDeityRegard(PlayerUtil.getUUID(player));
    }

    public DeityRegard getDeityRegard(UUID uuid) {
        ensureExists(uuid);
        return playerData.get(uuid).getRegard();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList regards = nbt.getTagList("praiseBeData", 10);
        for (var tag : regards) {
            NBTTagCompound tagCompound = (NBTTagCompound) tag;
            if (tagCompound == null)
                return;
            UUID uuid = tagCompound.getUniqueId("playerID");
            DeityRegard regard = new DeityRegard(tagCompound.getCompoundTag("regards"), this);
            PlayerAttributes attributes = new PlayerAttributes(tagCompound.getCompoundTag("attributes"));
            playerData.put(uuid, ImmutableWorldDataSet.builder() //
                    .regard(regard) //
                    .attributes(attributes) //
                    .build());
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagList regards = new NBTTagList();
        playerData.forEach((key, value) -> {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setUniqueId("playerID", key);
            tagCompound.setTag("regards", value.getRegard().serializeNBT());
            tagCompound.setTag("attributes", value.getAttributes().serializeNBT());
            regards.appendTag(tagCompound);
        });
        compound.setTag("praiseBeData", regards);
        return compound;
    }
}

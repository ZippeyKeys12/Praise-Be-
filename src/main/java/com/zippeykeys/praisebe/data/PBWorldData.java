package com.zippeykeys.praisebe.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.zippeykeys.praisebe.util.PlayerUtil;
import com.zippeykeys.praisebe.util.Reference;

import org.jetbrains.annotations.NotNull;

import lombok.var;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class PBWorldData extends WorldSavedData {
    public static final String ID = Reference.MOD_ID + "_Regards";

    private Map<UUID, GodlyRegard> playerRegards = new HashMap<>();

    public static PBWorldData of(@NotNull World world) {
        MapStorage storage = world.getMapStorage();
        PBWorldData instance = (PBWorldData) Objects.requireNonNull(storage).getOrLoadData(PBWorldData.class, ID);
        if (instance == null) {
            instance = new PBWorldData();
            storage.setData(ID, instance);
        }
        return instance;
    }

    private PBWorldData() {
        this(ID);
    }

    private PBWorldData(String id) {
        super(id);
    }

    public GodlyRegard getGodlyRegard(EntityPlayer player) {
        return getGodlyRegard(PlayerUtil.getUUID(player));
    }

    public GodlyRegard getGodlyRegard(UUID uuid) {
        return playerRegards.get(uuid);
    }

    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        NBTTagList regards = nbt.getTagList("godlyRegards", 10);
        for (var tag : regards) {
            NBTTagCompound tagCompound = (NBTTagCompound) tag;
            if (tagCompound == null)
                return;
            UUID uuid = tagCompound.getUniqueId("playerID");
            GodlyRegard regard = new GodlyRegard(Objects.requireNonNull(uuid), this);
            regard.deserializeNBT(tagCompound.getCompoundTag("regards"));
            playerRegards.put(uuid, regard);
        }
    }

    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound compound) {
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

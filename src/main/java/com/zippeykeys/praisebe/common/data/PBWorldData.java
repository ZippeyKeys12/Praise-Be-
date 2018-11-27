package com.zippeykeys.praisebe.common.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.zippeykeys.praisebe.common.util.Reference;

import org.jetbrains.annotations.NotNull;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class PBWorldData extends WorldSavedData {
    private static final String ID = Reference.MOD_ID + "_Regards";
    public Map<UUID, GodlyRegard> playerRegards = new HashMap<>();

    public static PBWorldData get(@NotNull World world) {
        MapStorage storage = world.getMapStorage();
        PBWorldData instance = (PBWorldData) storage.getOrLoadData(PBWorldData.class, ID);
        if (instance == null) {
            instance = new PBWorldData();
            storage.setData(ID, instance);
        }
        return instance;
    }

    public PBWorldData() {
        super(ID);
    }

    public PBWorldData(String id) {
        super(id);
    }

    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        NBTTagList regards = nbt.getTagList("godlyRegards", 10);
        regards.forEach((tag) -> {
            NBTTagCompound tagCompound = (NBTTagCompound) tag;
            if (tagCompound == null)
                return;
            UUID uuid = tagCompound.getUniqueId("playerID");
            GodlyRegard regard = new GodlyRegard(uuid, this);
            regard.deserializeNBT(tagCompound.getCompoundTag("regards"));
            playerRegards.put(uuid, regard);
        });
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

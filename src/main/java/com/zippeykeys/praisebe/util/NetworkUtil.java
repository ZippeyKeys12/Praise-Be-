package com.zippeykeys.praisebe.util;

import java.util.UUID;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.data.GodlyRegard;
import com.zippeykeys.praisebe.data.PBWorldData;

import lombok.experimental.UtilityClass;
import net.minecraft.entity.player.EntityPlayer;

@UtilityClass
public class NetworkUtil {
    private static PBWorldData worldData = Reference.INSTANCE.worldData();

    public static GodlyRegard getRegard(EntityPlayer player) {
        return worldData.getGodlyRegard(player);
    }

    public static GodlyRegard getRegard(UUID uuid) {
        return worldData.getGodlyRegard(uuid);
    }
}
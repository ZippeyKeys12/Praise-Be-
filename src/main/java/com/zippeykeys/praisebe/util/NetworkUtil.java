package com.zippeykeys.praisebe.util;

import java.util.UUID;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.data.DeityRegard;
import com.zippeykeys.praisebe.data.PBWorldData;

import lombok.experimental.UtilityClass;
import net.minecraft.entity.player.EntityPlayer;

@UtilityClass
public class NetworkUtil {
    private static PBWorldData worldData = Reference.INSTANCE.worldData();

    public static DeityRegard getRegard(EntityPlayer player) {
        return worldData.getDeityRegard(player);
    }

    public static DeityRegard getRegard(UUID uuid) {
        return worldData.getDeityRegard(uuid);
    }
}
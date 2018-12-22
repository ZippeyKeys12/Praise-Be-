package com.zippeykeys.praisebe.util;

import java.util.UUID;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.data.GodlyRegard;

import lombok.experimental.UtilityClass;
import net.minecraft.entity.player.EntityPlayer;

@UtilityClass
public class NetworkUtil {
    public static GodlyRegard getRegard(EntityPlayer player) {
        return Reference.INSTANCE.worldData().getGodlyRegard(player);
    }

    public static GodlyRegard getRegard(UUID uuid) {
        return Reference.INSTANCE.worldData().getGodlyRegard(uuid);
    }
}
package com.zippeykeys.praisebe.util;

import java.util.UUID;

import com.zippeykeys.praisebe.data.GodlyRegard;
import com.zippeykeys.praisebe.data.PBWorldData;

import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;

@UtilityClass
public class NetworkUtil {
    public static GodlyRegard getRegard(EntityPlayer player) {
        return getWorldData().getGodlyRegard(player);
    }

    public static GodlyRegard getRegard(UUID uuid) {
        return getWorldData().getGodlyRegard(uuid);
    }

    public static @NotNull PBWorldData getWorldData() {
        return PBWorldData.of(DimensionManager.getWorld(0));
    }
}
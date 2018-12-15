package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

@UtilityClass
public class Util {
    @Contract(pure = true)
    public static Side getLogicalSide(@NotNull World world) {
        if (world.isRemote) {
            return Side.CLIENT;
        } else {
            return Side.SERVER;
        }
    }
}
package com.zippeykeys.praisebe.util;

import lombok.experimental.UtilityClass;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

@UtilityClass
public class Util {
    public static Side getLogicalSide(final World world) {
        if (world.isRemote) {
            return Side.CLIENT;
        } else {
            return Side.SERVER;
        }
    }
}
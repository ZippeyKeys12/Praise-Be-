package com.zippeykeys.praisebe.util;

import com.zippeykeys.praisebe.Reference;

import org.jetbrains.annotations.Contract;

import lombok.experimental.UtilityClass;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

@UtilityClass
public class Util {
    public static Side getEffectiveSide() {
        return FMLCommonHandler.instance().getEffectiveSide();
    }

    @Contract(pure = true)
    public static Side getLogicalSide(World world) {
        if (world.isRemote) {
            return Side.CLIENT;
        } else {
            return Side.SERVER;
        }
    }

    @Contract("_ -> new")
    public static ResourceLocation getResource(String resourcePathIn) {
        return new ResourceLocation(Reference.MOD_ID, resourcePathIn);
    }
}
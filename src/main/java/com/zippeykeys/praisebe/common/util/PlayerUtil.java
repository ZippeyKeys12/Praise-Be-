package com.zippeykeys.praisebe.common.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.UUID;


public class PlayerUtil{
    public static EntityPlayer getPlayer(UUID uuid){
        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(uuid);
    }
}

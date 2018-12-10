package com.zippeykeys.praisebe.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.experimental.UtilityClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

@UtilityClass
public class PlayerUtil {
    public static @NotNull EntityPlayer getPlayer(@NotNull UUID uuid) {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(uuid);
    }

    public List<TileEntity> getBlocksNearby(@NotNull EntityPlayer player, @NotNull World world,
            @Nullable Class<? extends TileEntity> clazz) {
        return getBlocksNearby(player, world, clazz, 1);
    }

    public List<TileEntity> getBlocksNearby(@NotNull EntityPlayer player, @NotNull World world,
            @Nullable Class<? extends TileEntity> clazz, int range) {
        TileEntity tileEntity;
        List<TileEntity> tileEntities = new ArrayList<>();
        for (int x = -range; x <= range; x++)
            for (int y = -range; y <= range; y++)
                for (int z = -range; z <= range; z++) {
                    tileEntity = world.getTileEntity(player.getPosition().add(x, y, z));
                    if (clazz != null) {
                        if (clazz.isInstance(tileEntity))
                            tileEntities.add(tileEntity);
                    } else
                        tileEntities.add(tileEntity);
                }
        return tileEntities;
    }
}

package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

@UtilityClass
public class BlockUtil {
    public static @NotNull Item itemFromBlock(Block b) {
        return new ItemBlock(b).setRegistryName(b.getRegistryName());
    }
}
package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraft.block.BlockStone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@UtilityClass
public class Reference {
    public static final String MOD_ID = "praisebe";
    public static final String MOD_NAME = "Praise Be!";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String MOD_PACKAGE = "com.zippeykeys.praisebe";
    public static final String MOD_DEPENDENCIES = "";

    public static final String PROXY_SERVER = MOD_PACKAGE + ".proxy.ServerProxy";
    public static final String PROXY_CLIENT = MOD_PACKAGE + ".proxy.ClientProxy";

    public static final CreativeTabs TAB_GENERAL = new CreativeTabs("praisebe") {
        @Override
        @Contract(" -> new")
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(new BlockStone()));
        }
    };

    public static final CreativeTabs TAB_CELESTIAL = new CreativeTabs("praisebe.celestial") {
        @Override
        @Contract(" -> new")
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(new BlockStone()));
        }
    };

    public static final CreativeTabs TAB_TERRESTRIAL = new CreativeTabs("praisebe.terrestrial") {
        @Override
        @Contract(" -> new")
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(new BlockStone()));
        }
    };

    public static final CreativeTabs TAB_ETHEREAL = new CreativeTabs("praisebe.ethereal") {
        @Override
        @Contract(" -> new")
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(new BlockStone()));
        }
    };
}
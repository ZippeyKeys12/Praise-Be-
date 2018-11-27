package com.zippeykeys.praisebe.common.util;

import net.minecraft.block.BlockStone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Reference {
    public static final String MOD_ID = "praisebe";
    public static final String MOD_NAME = "Praise Be!";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String MOD_PACKAGE = "com.zippeykeys.praisebe";
    public static final String MOD_DEPENDENCIES = "";

    public static final String PROXY_SERVER = MOD_PACKAGE + ".proxy.ServerProxy";
    public static final String PROXY_CLIENT = MOD_PACKAGE + ".proxy.ClientProxy";

    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("praisebe") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(new BlockStone()));
        }
    };
}
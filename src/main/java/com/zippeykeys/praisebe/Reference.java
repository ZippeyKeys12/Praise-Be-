package com.zippeykeys.praisebe;

import java.util.Objects;

import com.zippeykeys.praisebe.block.ModBlocks;
import com.zippeykeys.praisebe.proxy.IProxy;
import com.zippeykeys.praisebe.util.RegistryUtil;

import org.jetbrains.annotations.Contract;

import lombok.experimental.UtilityClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;


@UtilityClass
public class Reference{
    public static final String MOD_ID = "praisebe";

    public static final String MOD_NAME = "Praise Be!";

    public static final String MOD_VERSION = "@VERSION@";

    public static final String MOD_PACKAGE = "com.zippeykeys.praisebe";

    public static final String MOD_DEPENDENCIES = "";

    public static final String PROXY_SERVER = MOD_PACKAGE + ".proxy.ServerProxy";

    public static final String PROXY_CLIENT = MOD_PACKAGE + ".proxy.ClientProxy";

    @Instance(MOD_ID)
    public static PraiseBe INSTANCE;

    @SidedProxy(clientSide = PROXY_CLIENT, serverSide = PROXY_SERVER)
    public static IProxy PROXY;

    public static final CreativeTabs TAB_GENERAL = new CreativeTabs("praisebe"){
        @Override
        @Contract(" -> new")
        public ItemStack getTabIconItem(){
            return new ItemStack(Item.getItemFromBlock(ModBlocks.BUILDING_BLOCK));
        }
    };

    public static final CreativeTabs TAB_CELESTIAL = new CreativeTabs("praisebe.celestial"){
        @Override
        @Contract(" -> new")
        public ItemStack getTabIconItem(){
            return new ItemStack(Objects.requireNonNull(RegistryUtil.getItem("minecraft:dirt")));
        }
    };

    public static final CreativeTabs TAB_TERRESTRIAL = new CreativeTabs("praisebe.terrestrial"){
        @Override
        @Contract(" -> new")
        public ItemStack getTabIconItem(){
            return new ItemStack(Objects.requireNonNull(RegistryUtil.getItem("minecraft:tnt")));
        }
    };

    public static final CreativeTabs TAB_ETHEREAL = new CreativeTabs("praisebe.ethereal"){
        @Override
        @Contract(" -> new")
        public ItemStack getTabIconItem(){
            return new ItemStack(Objects.requireNonNull(RegistryUtil.getItem("minecraft:stone")));
        }
    };
}
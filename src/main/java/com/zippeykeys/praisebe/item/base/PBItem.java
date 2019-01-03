package com.zippeykeys.praisebe.item.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.factory.PBItemBuilder;
import com.zippeykeys.praisebe.iface.ILocalize;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.var;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class PBItem extends Item implements ILocalize{
    @Getter(onMethod_ = @Override)
    protected final String name;

    @Getter
    protected final Map<String, ItemStack> oreDictEntries = new HashMap<>();

    public PBItem(String nameIn, CreativeTabs... creativeTabs){
        name = nameIn;
        setRegistryName(getResource());
        setUnlocalizedName(Reference.MOD_ID + "." + getRegistryName().getResourcePath());
        Arrays.stream(creativeTabs) //
          .filter(Objects::nonNull) //
          .forEach(this::setCreativeTab);
    }

    public void addOreDictEntry(String entry){
        oreDictEntries.put(entry, new ItemStack(this));
    }

    public void addAllOreDictEntry(Collection<String> entriesIn){
        for(var entry : entriesIn){
            addOreDictEntry(entry);
        }
    }

    @Override
    public String getPrefix(){
        return "item";
    }

    @Contract(" -> new")
    public static @NotNull
    PBItemBuilder builder(){
        return new PBItemBuilder();
    }
}
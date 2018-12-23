package com.zippeykeys.praisebe.factory;

import java.util.List;
import java.util.Optional;

import com.zippeykeys.praisebe.item.base.PBItem;

import org.immutables.builder.Builder.Factory;
import org.immutables.value.Value.Style;

import lombok.val;
import net.minecraft.creativetab.CreativeTabs;

@Style(depluralize = true, depluralizeDictionary = { "entry:entries" }, strictBuilder = true)

public class ItemFactory {
    @Factory
    public static PBItem PBItem(String name, Optional<Integer> maxDamage, Optional<Integer> maxStackSize,
            Optional<Boolean> cantRepair, List<CreativeTabs> creativeTabs, List<String> oreDictEntries) {
        val result = new PBItem(name, creativeTabs.toArray(new CreativeTabs[0]));
        result.setMaxDamage(maxDamage.orElse(0));
        result.setMaxStackSize(maxStackSize.orElse(64));
        if (cantRepair.orElse(false)) {
            result.setNoRepair();
        }
        result.addAllOreDictEntry(oreDictEntries);
        return result;
    }
}
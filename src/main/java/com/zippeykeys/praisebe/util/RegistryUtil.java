package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistryEntry;

@UtilityClass
public class RegistryUtil {
    public static Biome getBiome(String key) {
        return getBiome(new ResourceLocation(key));
    }

    public static Biome getBiome(ResourceLocation key) {
        return ForgeRegistries.BIOMES.getValue(key);
    }

    public static Block getBlock(String key) {
        return getBlock(new ResourceLocation(key));
    }

    public static Block getBlock(ResourceLocation key) {
        return ForgeRegistries.BLOCKS.getValue(key);
    }

    public static Enchantment getEnchantment(String key) {
        return getEnchantment(new ResourceLocation(key));
    }

    public static Enchantment getEnchantment(ResourceLocation key) {
        return ForgeRegistries.ENCHANTMENTS.getValue(key);
    }

    public static EntityEntry getEntity(String key) {
        return getEntity(new ResourceLocation(key));
    }

    public static EntityEntry getEntity(ResourceLocation key) {
        return ForgeRegistries.ENTITIES.getValue(key);
    }

    public static Item getItem(String key) {
        return getItem(new ResourceLocation(key));
    }

    public static Item getItem(ResourceLocation key) {
        return ForgeRegistries.ITEMS.getValue(key);
    }

    public static Potion getPotion(String key) {
        return getPotion(new ResourceLocation(key));
    }

    public static Potion getPotion(ResourceLocation key) {
        return ForgeRegistries.POTIONS.getValue(key);
    }

    public static PotionType getPotionType(String key) {
        return getPotionType(new ResourceLocation(key));
    }

    public static PotionType getPotionType(ResourceLocation key) {
        return ForgeRegistries.POTION_TYPES.getValue(key);
    }

    public static IRecipe getRecipe(String key) {
        return getRecipe(new ResourceLocation(key));
    }

    public static IRecipe getRecipe(ResourceLocation key) {
        return ForgeRegistries.RECIPES.getValue(key);
    }

    public static SoundEvent getSoundEvent(String key) {
        return getSoundEvent(new ResourceLocation(key));
    }

    public static SoundEvent getSoundEvent(ResourceLocation key) {
        return ForgeRegistries.SOUND_EVENTS.getValue(key);
    }

    public static VillagerProfession getVillagerProfession(String key) {
        return getVillagerProfession(new ResourceLocation(key));
    }

    public static VillagerProfession getVillagerProfession(ResourceLocation key) {
        return ForgeRegistries.VILLAGER_PROFESSIONS.getValue(key);
    }

    @Contract("_, _ -> param1")
    public static @NotNull <T extends IForgeRegistryEntry<? super T>> T transferRegistryName(@NotNull T main,
            @NotNull IForgeRegistryEntry<?> other) {
        main.setRegistryName(other.getRegistryName());
        return main;
    }
}
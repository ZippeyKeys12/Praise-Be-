package com.zippeykeys.praisebe.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    public static @Nullable Biome getBiome(String key) {
        return getBiome(new ResourceLocation(key));
    }

    public static @Nullable Biome getBiome(ResourceLocation key) {
        return ForgeRegistries.BIOMES.getValue(key);
    }

    public static @Nullable Block getBlock(String key) {
        return getBlock(new ResourceLocation(key));
    }

    public static @Nullable Block getBlock(ResourceLocation key) {
        return ForgeRegistries.BLOCKS.getValue(key);
    }

    public static @Nullable Enchantment getEnchantment(String key) {
        return getEnchantment(new ResourceLocation(key));
    }

    public static @Nullable Enchantment getEnchantment(ResourceLocation key) {
        return ForgeRegistries.ENCHANTMENTS.getValue(key);
    }

    public static @Nullable EntityEntry getEntity(String key) {
        return getEntity(new ResourceLocation(key));
    }

    public static @Nullable EntityEntry getEntity(ResourceLocation key) {
        return ForgeRegistries.ENTITIES.getValue(key);
    }

    public static @Nullable Item getItem(String key) {
        return getItem(new ResourceLocation(key));
    }

    public static @Nullable Item getItem(ResourceLocation key) {
        return ForgeRegistries.ITEMS.getValue(key);
    }

    public static @Nullable Potion getPotion(String key) {
        return getPotion(new ResourceLocation(key));
    }

    public static @Nullable Potion getPotion(ResourceLocation key) {
        return ForgeRegistries.POTIONS.getValue(key);
    }

    public static @Nullable PotionType getPotionType(String key) {
        return getPotionType(new ResourceLocation(key));
    }

    public static @Nullable PotionType getPotionType(ResourceLocation key) {
        return ForgeRegistries.POTION_TYPES.getValue(key);
    }

    public static @Nullable IRecipe getRecipe(String key) {
        return getRecipe(new ResourceLocation(key));
    }

    public static @Nullable IRecipe getRecipe(ResourceLocation key) {
        return ForgeRegistries.RECIPES.getValue(key);
    }

    public static @Nullable SoundEvent getSoundEvent(String key) {
        return getSoundEvent(new ResourceLocation(key));
    }

    public static @Nullable SoundEvent getSoundEvent(ResourceLocation key) {
        return ForgeRegistries.SOUND_EVENTS.getValue(key);
    }

    public static @Nullable VillagerProfession getVillagerProfession(String key) {
        return getVillagerProfession(new ResourceLocation(key));
    }

    public static @Nullable VillagerProfession getVillagerProfession(ResourceLocation key) {
        return ForgeRegistries.VILLAGER_PROFESSIONS.getValue(key);
    }

    @Contract("_, _ -> param1")
    public static @NotNull <T extends IForgeRegistryEntry<? super T>> T transferRegistryName(@NotNull T main,
            @NotNull IForgeRegistryEntry<?> other) {
        main.setRegistryName(other.getRegistryName());
        return main;
    }
}
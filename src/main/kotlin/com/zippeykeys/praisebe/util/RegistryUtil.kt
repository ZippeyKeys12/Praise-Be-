package com.zippeykeys.praisebe.util

import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.Item
import net.minecraft.item.crafting.IRecipe
import net.minecraft.potion.Potion
import net.minecraft.potion.PotionType
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundEvent
import net.minecraft.world.biome.Biome
import net.minecraftforge.fml.common.registry.EntityEntry
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession
import net.minecraftforge.registries.IForgeRegistryEntry


fun getBiome(key: String): Biome? {
    return getBiome(ResourceLocation(key))
}

fun getBiome(key: ResourceLocation): Biome? {
    return ForgeRegistries.BIOMES.getValue(key)
}

fun getBlock(key: String): Block? {
    return getBlock(ResourceLocation(key))
}

fun getBlock(key: ResourceLocation): Block? {
    return ForgeRegistries.BLOCKS.getValue(key)
}

fun getEnchantment(key: String): Enchantment? {
    return getEnchantment(ResourceLocation(key))
}

fun getEnchantment(key: ResourceLocation): Enchantment? {
    return ForgeRegistries.ENCHANTMENTS.getValue(key)
}

fun getEntity(key: String): EntityEntry? {
    return getEntity(ResourceLocation(key))
}

fun getEntity(key: ResourceLocation): EntityEntry? {
    return ForgeRegistries.ENTITIES.getValue(key)
}

fun getItem(key: String): Item? {
    return getItem(ResourceLocation(key))
}

fun getItem(key: ResourceLocation): Item? {
    return ForgeRegistries.ITEMS.getValue(key)
}

fun getPotion(key: String): Potion? {
    return getPotion(ResourceLocation(key))
}

fun getPotion(key: ResourceLocation): Potion? {
    return ForgeRegistries.POTIONS.getValue(key)
}

fun getPotionType(key: String): PotionType? {
    return getPotionType(ResourceLocation(key))
}

fun getPotionType(key: ResourceLocation): PotionType? {
    return ForgeRegistries.POTION_TYPES.getValue(key)
}

fun getRecipe(key: String): IRecipe? {
    return getRecipe(ResourceLocation(key))
}

fun getRecipe(key: ResourceLocation): IRecipe? {
    return ForgeRegistries.RECIPES.getValue(key)
}

fun getSoundEvent(key: String): SoundEvent? {
    return getSoundEvent(ResourceLocation(key))
}

fun getSoundEvent(key: ResourceLocation): SoundEvent? {
    return ForgeRegistries.SOUND_EVENTS.getValue(key)
}

fun getVillagerProfession(key: String): VillagerProfession? {
    return getVillagerProfession(ResourceLocation(key))
}

fun getVillagerProfession(key: ResourceLocation): VillagerProfession? {
    return ForgeRegistries.VILLAGER_PROFESSIONS.getValue(key)
}

fun <T : IForgeRegistryEntry<in T>> transferRegistryName(main: T, other: IForgeRegistryEntry<*>): T {
    main.registryName = other.registryName
    return main
}
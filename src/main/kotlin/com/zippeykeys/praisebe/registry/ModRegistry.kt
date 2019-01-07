package com.zippeykeys.praisebe.registry

import com.google.common.collect.ImmutableSet
import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.block.ModBlocks
import com.zippeykeys.praisebe.block.ModMultiblocks
import com.zippeykeys.praisebe.block.base.PBBlock
import com.zippeykeys.praisebe.block.multi.Multiblock
import com.zippeykeys.praisebe.deity.Affinity
import com.zippeykeys.praisebe.deity.Deity
import com.zippeykeys.praisebe.deity.ModAffinities
import com.zippeykeys.praisebe.deity.ModDeities
import com.zippeykeys.praisebe.item.ModItems
import com.zippeykeys.praisebe.item.base.PBItem
import com.zippeykeys.praisebe.util.getDeclaredFields
import com.zippeykeys.praisebe.util.getFieldValue
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent.Register
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.oredict.OreDictionary
import net.minecraftforge.registries.IForgeRegistryEntry
import java.lang.reflect.Field
import java.util.Arrays
import java.util.Objects
import java.util.function.Function
import java.util.stream.Stream


@EventBusSubscriber(modid = Reference.MOD_ID)
object ModRegistry {
    val BLOCKS: Set<PBBlock>

    val MULTIBLOCKS: Set<Multiblock>

    val ITEMS: Set<PBItem>

    val DEITIES: Set<Deity>

    val AFFINITIES: Set<Affinity>

    init {
        val blocks = ImmutableSet.builder<PBBlock>()
        Arrays.stream<Field>(ModBlocks::class.java.declaredFields)
                .map<PBBlock> { x -> getFieldValue(x) as PBBlock? }
                .filter { Objects.nonNull(it) }
                .forEach { blocks.add(it) }
        BLOCKS = blocks.build()

        val multiblocks = ImmutableSet.builder<Multiblock>()
        Arrays.stream<Field>(ModMultiblocks::class.java.declaredFields)
                .map<Multiblock> { x -> getFieldValue(x) as Multiblock? }
                .filter { Objects.nonNull(it) }
                .forEach { multiblocks.add(it) }
        MULTIBLOCKS = multiblocks.build()

        val items = ImmutableSet.builder<PBItem>()
        Arrays.stream<Field>(ModItems::class.java.declaredFields)
                .map<PBItem> { x -> getFieldValue(x) as PBItem? }
                .filter { Objects.nonNull(it) }
                .forEach { items.add(it) }
        ITEMS = items.build()

        val deities = ImmutableSet.builder<Deity>()
        Arrays.stream<Field>(getDeclaredFields(*ModDeities::class.java.declaredClasses))
                .map<Deity> { x -> getFieldValue(x) as Deity? }
                .filter { Objects.nonNull(it) }
                .forEach { deities.add(it) }
        DEITIES = deities.build()

        val affinities = ImmutableSet.builder<Affinity>()
        Arrays.stream<Field>(ModAffinities::class.java.declaredFields)
                .map<Affinity> { x -> getFieldValue(x) as Affinity? }
                .filter { Objects.nonNull(it) }
                .forEach { affinities.add(it) }
        AFFINITIES = affinities.build()
    }

    @SubscribeEvent
    fun registerBlocks(event: Register<Block>) {
        register(event, BLOCKS)
        BLOCKS.stream()
                .filter { Objects.nonNull(it.tileEntity) }
                .forEach { it ->
                    GameRegistry.registerTileEntity(
                            it.tileEntity, it.resource
                    )

                }
    }

    @SubscribeEvent
    fun registerMultiblocks(event: Register<Multiblock>) {
        register(event, MULTIBLOCKS)
    }

    @SubscribeEvent
    fun registerItems(event: Register<Item>) {
        // Blocks //
        register(event, Function { it.item }, BLOCKS)
        BLOCKS.stream()
                .map<Map<String, ItemStack>> { it.oreDictEntries }
                .forEach { entries -> entries.forEach { name, ore -> OreDictionary.registerOre(name, ore) } }
        // Items //
        register(event, ITEMS)
        ITEMS.stream()
                .map<Map<String, ItemStack>> { it.oreDictEntries }
                .forEach { entries -> entries.forEach { name, ore -> OreDictionary.registerOre(name, ore) } }
    }

    @SubscribeEvent
    fun registerDeities(event: Register<Deity>) {
        register(event, DEITIES)
    }

    @SubscribeEvent
    fun registerAffinities(event: Register<Affinity>) {
        register(event, AFFINITIES)
    }

    fun <T : IForgeRegistryEntry<T>, R : IForgeRegistryEntry<R>, K : T> register(
            e: Register<R>, mapper: Function<K, R>, values: Collection<K>) {
        register(e, mapper, values.stream())
    }

    @SafeVarargs
    fun <T : IForgeRegistryEntry<T>, R : IForgeRegistryEntry<R>, K : T> register(
            e: Register<R>, mapper: Function<K, R>, vararg values: K) {
        register(e, mapper, Arrays.stream(values))
    }

    fun <T : IForgeRegistryEntry<T>, R : IForgeRegistryEntry<R>, K : T> register(
            e: Register<R>, mapper: Function<K, R>, values: Stream<K>) {
        register(e, values.map(mapper))
    }

    fun <T : IForgeRegistryEntry<T>, K : T> register(e: Register<T>, values: Stream<K>) {
        val r = e.registry
        values.forEach { r.register(it) }
    }

    fun <T : IForgeRegistryEntry<T>> register(e: Register<T>, values: Collection<T>) {
        val r = e.registry
        values.forEach { r.register(it) }
    }

    @SafeVarargs
    fun <T : IForgeRegistryEntry<T>> register(e: Register<T>, vararg values: T) {
        e.registry.registerAll(*values)
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    fun registerModels(event: ModelRegistryEvent) {
        BLOCKS.forEach { block ->
            val identifier = block.registryName
            val item = Item.getItemFromBlock(block)
            if (identifier == null || item === Items.AIR) {
                return
            }
            for (entry in block.variants.int2ObjectEntrySet()) {
                ModelLoader.setCustomModelResourceLocation(item, entry.intKey,
                        ModelResourceLocation(identifier, entry.value)
                )
            }
        }
    }
}
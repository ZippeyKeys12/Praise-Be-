package com.zippeykeys.praisebe.registry;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;
import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.block.ModBlocks;
import com.zippeykeys.praisebe.block.ModMultiblocks;
import com.zippeykeys.praisebe.block.base.PBBlock;
import com.zippeykeys.praisebe.block.multi.Multiblock;
import com.zippeykeys.praisebe.deity.Affinity;
import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.deity.ModAffinities;
import com.zippeykeys.praisebe.deity.ModDeities;
import com.zippeykeys.praisebe.item.ModItems;
import com.zippeykeys.praisebe.item.base.PBItem;
import com.zippeykeys.praisebe.util.ClassUtil;

import lombok.val;
import lombok.var;
import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

@UtilityClass
@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRegistry {
    public static final Set<PBBlock> BLOCKS;

    public static final Set<Multiblock> MULTIBLOCKS;

    public static final Set<PBItem> ITEMS;

    public static final Set<Deity> DEITIES;

    public static final Set<Affinity> AFFINITIES;

    static {
        val blocks = ImmutableSet.<PBBlock>builder();
        Arrays.stream(ModBlocks.class.getDeclaredFields()) //
                .map(x -> (PBBlock) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(blocks::add);
        BLOCKS = blocks.build();

        val multiblocks = ImmutableSet.<Multiblock>builder();
        Arrays.stream(ModMultiblocks.class.getDeclaredFields()) //
                .map(x -> (Multiblock) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(multiblocks::add);
        MULTIBLOCKS = multiblocks.build();

        val items = ImmutableSet.<PBItem>builder();
        Arrays.stream(ModItems.class.getDeclaredFields()) //
                .map(x -> (PBItem) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(items::add);
        ITEMS = items.build();

        val deities = ImmutableSet.<Deity>builder();
        Arrays.stream(ClassUtil.getDeclaredFields(ModDeities.class.getDeclaredClasses())) //
                .map(x -> (Deity) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(deities::add);
        DEITIES = deities.build();

        val affinities = ImmutableSet.<Affinity>builder();
        Arrays.stream(ModAffinities.class.getDeclaredFields()) //
                .map(x -> (Affinity) ClassUtil.getFieldValue(x)) //
                .filter(Objects::nonNull) //
                .forEach(affinities::add);
        AFFINITIES = affinities.build();
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        register(event, BLOCKS);
        BLOCKS.stream() //
                .map(PBBlock::getTileEntity) //
                .filter(Objects::nonNull) //
                .forEach(tileEntity -> GameRegistry.registerTileEntity(tileEntity,
                        (ResourceLocation) Objects.requireNonNull(ClassUtil.callDeclaredMethod(tileEntity,
                                "getResource", ClassUtil.newInstance(tileEntity)))));
    }

    @SubscribeEvent
    public static void registerMultiblocks(Register<Multiblock> event) {
        register(event, MULTIBLOCKS);
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        // Blocks //
        register(event, PBBlock::getItem, BLOCKS);
        BLOCKS.stream() //
                .map(PBBlock::getOreDictEntries) //
                .forEach(entries -> entries.forEach(OreDictionary::registerOre));

        // Items //
        register(event, ITEMS);
        ITEMS.stream() //
                .map(PBItem::getOreDictEntries) //
                .forEach(entries -> entries.forEach(OreDictionary::registerOre));
    }

    @SubscribeEvent
    public static void registerDeities(Register<Deity> event) {
        register(event, DEITIES);
    }

    @SubscribeEvent
    public static void registerAffinities(Register<Affinity> event) {
        register(event, AFFINITIES);
    }

    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>, K extends T> void register(
            Register<R> e, Function<K, R> mapper, Collection<K> values) {
        register(e, mapper, values.stream());
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>, K extends T> void register(
            Register<R> e, Function<K, R> mapper, K... values) {
        register(e, mapper, Arrays.stream(values));
    }

    public static <T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>, K extends T> void register(
            Register<R> e, Function<K, R> mapper, Stream<K> values) {
        register(e, values.map(mapper));
    }

    public static <T extends IForgeRegistryEntry<T>, K extends T> void register(Register<T> e, Stream<K> values) {
        val r = e.getRegistry();
        values.forEach(r::register);
    }

    public static <T extends IForgeRegistryEntry<T>> void register(Register<T> e, Collection<? extends T> values) {
        val r = e.getRegistry();
        values.forEach(r::register);
    }

    @SafeVarargs
    public static <T extends IForgeRegistryEntry<T>> void register(Register<T> e, T... values) {
        e.getRegistry().registerAll(values);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        BLOCKS.forEach(block -> {
            val identifier = block.getRegistryName();
            val item = Item.getItemFromBlock(block);
            if (identifier == null || item == Items.AIR) {
                return;
            }
            for (var entry : block.getVariants().int2ObjectEntrySet()) {
                ModelLoader.setCustomModelResourceLocation(item, entry.getIntKey(),
                        new ModelResourceLocation(identifier, entry.getValue()));
            }
        });
    }
}
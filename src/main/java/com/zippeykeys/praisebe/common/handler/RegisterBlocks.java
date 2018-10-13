package com.zippeykeys.praisebe.common.handler;

import com.zippeykeys.praisebe.common.PraiseBe;
import com.zippeykeys.praisebe.common.block.BlockIdol;
import com.zippeykeys.praisebe.common.block.IPBBlock;
import com.zippeykeys.praisebe.common.tileentity.TileIdol;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


//@Mod.EventBusSubscriber(modid = PraiseBe.MODID)
public class RegisterBlocks{
    public static final Block[] blocks = new Block[]{new BlockIdol().setRegistryName("idol")};

    @SubscribeEvent
    public static void registerBlocks(@NotNull RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(blocks);
        //Arrays.stream(blocks).filter(Objects::nonNull).forEach(block -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
        ///////////////////
        // Tile Entities //
        ///////////////////
        GameRegistry.registerTileEntity(TileIdol.class, new ResourceLocation(PraiseBe.MODID, "idol"));
    }

    @SubscribeEvent
    public static void registerItemBlocks(@NotNull RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> r = event.getRegistry();
        Arrays.stream(blocks).filter(block -> block instanceof IPBBlock).forEach(b -> {
            r.register(((IPBBlock) b).getItem().setRegistryName(b.getRegistryName()));
        });
    }
}

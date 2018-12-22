package com.zippeykeys.praisebe.registry;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.block.multi.Multiblock;

import lombok.NoArgsConstructor;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@NoArgsConstructor
@EventBusSubscriber(modid = Reference.MOD_ID)
public class MultiblockRegistry extends PBRegistry<Multiblock> {

}
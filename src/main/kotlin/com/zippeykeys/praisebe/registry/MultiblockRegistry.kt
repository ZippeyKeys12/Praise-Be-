package com.zippeykeys.praisebe.registry

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.block.multi.Multiblock
import net.minecraftforge.fml.common.Mod.EventBusSubscriber

@EventBusSubscriber(modid = Reference.MOD_ID)
class MultiblockRegistry : PBRegistry<Multiblock>()
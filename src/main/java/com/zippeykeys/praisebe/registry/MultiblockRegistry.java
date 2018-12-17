package com.zippeykeys.praisebe.registry;

import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class MultiblockRegistry extends PBRegistry<MultiblockRegistry.IMultiblock> {
    public MultiblockRegistry() {
        super(IMultiblock.class);
    }

    public interface IMultiblock extends Localize {
        boolean isTrigger(IBlockState state);

        boolean isValid();
    }
}
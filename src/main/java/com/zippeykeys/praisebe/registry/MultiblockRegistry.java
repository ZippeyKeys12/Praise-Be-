package com.zippeykeys.praisebe.registry;

import com.zippeykeys.praisebe.util.Localize;
import com.zippeykeys.praisebe.util.Reference;

import lombok.NoArgsConstructor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@NoArgsConstructor
@EventBusSubscriber(modid = Reference.MOD_ID)
public class MultiblockRegistry extends PBRegistry<MultiblockRegistry.IMultiblock> {
    public interface IMultiblock extends Localize {
        boolean isTrigger(IBlockState state);

        String[][][] getStructure();

        boolean isValid(World world, BlockPos pos, EntityPlayer player);

        boolean buildStructure(World world, BlockPos pos);
    }
}
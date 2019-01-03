package com.zippeykeys.praisebe.block.multi;

import java.util.ArrayList;
import java.util.List;

import com.zippeykeys.praisebe.factory.MultiblockBuilder;
import com.zippeykeys.praisebe.iface.ILocalize;

import org.apache.logging.log4j.util.TriConsumer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.var;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;


@AllArgsConstructor
public class Multiblock extends IForgeRegistryEntry.Impl<Multiblock> implements ILocalize{
    @Getter(onMethod_ = @Override)
    private final String name;

    @Getter
    private final EMBActivator activator;

    @Getter
    private final IBlockState trigger;

    @Getter
    public final List<MultiblockPart> parts = new ArrayList<>();

    private final TriConsumer<Multiblock, World, BlockPos> structureBuilder;

    public boolean isValid(World world, BlockPos pos, EntityPlayer player){
        for(var i = 0; i < 4; i++){
            if(checkStructure(world, pos, player)){
                return true;
            }
            getParts().forEach(MultiblockPart::rotate);
        }
        return false;
    }

    public boolean addPart(MultiblockPart part){
        if(getPartAt(part.getPos()) != null){
            return false;
        }
        return parts.add(part);
    }

    public @Nullable MultiblockPart getPartAt(BlockPos pos){
        return getParts() //
          .stream() //
          .filter(x -> x.getPos() == pos) //
          .findAny() //
          .orElse(null);
    }

    public boolean checkStructure(World world, BlockPos pos, EntityPlayer player){
        return getParts() //
          .stream() //
          .allMatch(x -> world.getBlockState(pos.add(x.getPos()))
            .equals(x.getBlockState()));
    }

    public void buildStructure(World world, BlockPos blockPos){
        structureBuilder.accept(this, world, blockPos);
    }

    @Override
    public String getPrefix(){
        return "multiblock";
    }

    @Contract("_ -> new")
    public static MultiblockBuilder builder(TriConsumer<Multiblock, World, BlockPos> structureBuilder){
        return new MultiblockBuilder(structureBuilder);
    }
}
package com.zippeykeys.praisebe.factory;

import java.util.List;
import java.util.Optional;

import com.zippeykeys.praisebe.block.base.BlockEnum;
import com.zippeykeys.praisebe.block.base.PBBlock;
import com.zippeykeys.praisebe.block.multi.EMBActivator;
import com.zippeykeys.praisebe.block.multi.Multiblock;
import com.zippeykeys.praisebe.block.multi.MultiblockPart;
import com.zippeykeys.praisebe.block.tile.base.PBTileEntity;
import com.zippeykeys.praisebe.iface.ILocalize;
import com.zippeykeys.praisebe.util.Util;

import org.apache.logging.log4j.util.TriConsumer;
import org.immutables.builder.Builder.Factory;
import org.immutables.builder.Builder.Parameter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import lombok.experimental.UtilityClass;
import lombok.val;
import lombok.var;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


@UtilityClass
public class BlockFactory{
    @Factory
    @Contract(value = "_, _, _, _, _ -> new", pure = true)
    public static PBBlock PBBlock(String name, Material material, Optional<MapColor> color,
      List<CreativeTabs> creativeTabs, List<String> oreDictEntries){
        val result = new PBBlock(name, material, color.orElse(material.getMaterialMapColor()),
          creativeTabs.toArray(new CreativeTabs[0])
        );
        result.addAllOreDictEntry(oreDictEntries);
        return result;
    }

    @Factory
    @Contract(value = "_, _, _, _, _, _, _ -> new", pure = true)
    public static <T extends Enum<T> & ILocalize> BlockEnum<T> BlockEnum(String name, Material material,
      @Parameter Class<T> clazz, Optional<Class<? extends PBTileEntity>> tileClass, Optional<String> propertyName,
      List<CreativeTabs> creativeTabs, List<String> oreDictEntries){
        val result = new BlockEnum<T>(name, material, clazz, propertyName.orElse("type"),
          creativeTabs.toArray(new CreativeTabs[0])
        ){
            @Override
            @Contract(pure = true)
            public @Nullable Class<? extends PBTileEntity> getTileEntity(){
                return tileClass.orElse(null);
            }
        };
        result.addAllOreDictEntry(oreDictEntries);
        return result;
    }

    @Factory
    @Contract("_, _, _, _, _ -> new")
    public static Multiblock Multiblock(String name, Optional<EMBActivator> activator, IBlockState trigger,
      List<? extends MultiblockPart> parts, @Parameter TriConsumer<Multiblock, World, BlockPos> structureBuilder){
        val result = new Multiblock(name, activator.orElse(EMBActivator.values()[0]), trigger, structureBuilder);
        result.setRegistryName(Util.getResource(result.getName()));
        for(var part : parts){
            result.addPart(part);
        }
        return result;
    }

    @Factory
    @Contract(value = "_, _, _ -> new", pure = true)
    public static MultiblockPart MultiblockPart(BlockPos pos, IBlockState blockState, Optional<? extends TileEntity> tileEntity){
        return new MultiblockPart(pos, blockState, tileEntity.orElse(null));
    }
}
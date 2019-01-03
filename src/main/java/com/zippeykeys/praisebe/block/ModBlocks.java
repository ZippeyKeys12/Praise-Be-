package com.zippeykeys.praisebe.block;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.block.base.BlockEnum;
import com.zippeykeys.praisebe.block.base.PBBlock;

import lombok.experimental.UtilityClass;

import net.minecraft.block.material.Material;


@UtilityClass
public class ModBlocks{
    // Building //
    public static final PBBlock BUILDING_BLOCK = BlockEnum.builder(EBuildingBlock.class) //
      .name("buildingStone") //
      .material(Material.ROCK) //
      .addCreativeTab(Reference.TAB_GENERAL) //
      .addOreDictEntry("block") //
      .build();

    public static final PBBlock ROCK_ORE = BlockEnum.builder(EOreBlock.class) //
      .name("rockOre") //
      .material(Material.ROCK) //
      .addCreativeTab(Reference.TAB_GENERAL) //
      .addOreDictEntry("ore") //
      .build();

    public static final PBBlock SAND_ORE = BlockEnum.builder(EOreBlock.class) //
      .name("sandOre") //
      .material(Material.SAND) //
      .addCreativeTab(Reference.TAB_GENERAL) //
      .addOreDictEntry("ore") //
      .build();
}

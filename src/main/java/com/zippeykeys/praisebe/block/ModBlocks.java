package com.zippeykeys.praisebe.block;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.block.base.BlockEnum;
import com.zippeykeys.praisebe.block.base.PBBlock;

import lombok.experimental.UtilityClass;
import net.minecraft.block.material.Material;

@UtilityClass
public class ModBlocks {
        // Building //
        public static final PBBlock BUILDING_BLOCK = BlockEnum.builder(EBuildingBlock.class) //
                        .name("buildingstone") //
                        .material(Material.ROCK) //
                        .creativeTabs(Reference.TAB_GENERAL) //
                        .build();

        public static final PBBlock ROCK_ORE = BlockEnum.builder(EOreBlock.class) //
                        .name("rockOre") //
                        .material(Material.ROCK) //
                        .creativeTabs(Reference.TAB_GENERAL) //
                        .build();

        public static final PBBlock SAND_ORE = BlockEnum.builder(EOreBlock.class) //
                        .name("sandOre") //
                        .material(Material.SAND) //
                        .creativeTabs(Reference.TAB_GENERAL) //
                        .build();
}

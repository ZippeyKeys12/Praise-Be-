package com.zippeykeys.praisebe.block;

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
            .build();
}

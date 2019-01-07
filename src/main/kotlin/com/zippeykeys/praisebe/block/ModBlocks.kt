package com.zippeykeys.praisebe.block

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.block.base.BlockEnum
import com.zippeykeys.praisebe.block.base.PBBlock
import net.minecraft.block.material.Material


object ModBlocks {
    // Building //
    val BUILDING_BLOCK: PBBlock = BlockEnum(
            name = "buildingStone",
            material = Material.ROCK,
            clazz = EBuildingBlock::class.java,
            creativeTab = Reference.TAB_GENERAL
    )
            .addOreDictEntry("block")

    val ROCK_ORE: PBBlock = BlockEnum(
            name = "rockOre",
            material = Material.ROCK,
            clazz = EOreBlock::class.java,
            creativeTab = Reference.TAB_GENERAL
    )
            .addOreDictEntry("ore")

    val SAND_ORE: PBBlock = BlockEnum(
            name = "sandOre",
            material = Material.SAND,
            clazz = EOreBlock::class.java,
            creativeTab = Reference.TAB_GENERAL
    )
            .addOreDictEntry("ore")
}
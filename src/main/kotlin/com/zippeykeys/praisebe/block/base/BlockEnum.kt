package com.zippeykeys.praisebe.block.base

import com.zippeykeys.praisebe.block.tile.base.PBTileEntity
import com.zippeykeys.praisebe.iface.ILocalize
import com.zippeykeys.praisebe.item.block.ItemBlockEnum
import com.zippeykeys.praisebe.util.transferRegistryName
import it.unimi.dsi.fastutil.ints.Int2ObjectMap
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList


open class BlockEnum<T>(name: String, material: Material,
        clazz: Class<T>,
        tileClass: Class<out PBTileEntity>? = null,
        propertyName: String = "type", creativeTab: CreativeTabs? = null) :
        PBBlock(name, material, material.materialMapColor, tileClass,
                creativeTab) where T : Enum<T>, T : ILocalize {
    val values: Array<T>

    private val dataPropertyEnum: PropertyEnum<T> = PropertyEnum.create(propertyName, clazz)

    private val newBlockState: BlockStateContainer

    override val item: ItemBlock
        get() = transferRegistryName(ItemBlockEnum(this), this)

    override val variants: Int2ObjectMap<String>
        get() {
            val variants = Int2ObjectOpenHashMap<String>()
            for (i in values.indices) {
                variants[i] = dataPropertyEnum.name + "=" + values[i].name
            }
            return variants
        }

    init {
        @Suppress("LeakingThis")
        newBlockState = BlockStateContainer.Builder(this)
                .add(dataPropertyEnum)
                .build()
        values = clazz.enumConstants
        defaultState = getBlockState().baseState
    }

    override fun addOreDictEntry(entry: String): BlockEnum<T> {
        for (value in values) {
            oreDictEntries[entry + value.name] = ItemStack(this, 1, value.ordinal)
        }
        return this
    }

    override fun addAllOreDictEntry(entriesIn: Collection<String>): BlockEnum<T> {
        for (entry in entriesIn) {
            addOreDictEntry(entry)
        }
        return this
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this)
    }

    final override fun getBlockState(): BlockStateContainer {
        return newBlockState
    }

    @Suppress("OverridingDeprecatedMember")
    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState.withProperty(dataPropertyEnum, values[meta])
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return state.getValue(dataPropertyEnum)
                .ordinal
    }

    override fun damageDropped(state: IBlockState): Int {
        return getMetaFromState(state)
    }

    override fun getSubBlocks(tab: CreativeTabs, items: NonNullList<ItemStack>) {
        for (value in values) {
            items.add(ItemStack(this, 1, value.ordinal))
        }
    }

    protected fun createStateContainer(): BlockStateContainer {
        return BlockStateContainer.Builder(this)
                .add(dataPropertyEnum)
                .build()
    }
}
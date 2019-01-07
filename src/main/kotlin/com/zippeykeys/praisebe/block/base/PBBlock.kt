package com.zippeykeys.praisebe.block.base

import com.zippeykeys.praisebe.Reference
import com.zippeykeys.praisebe.block.tile.base.PBTileEntity
import com.zippeykeys.praisebe.iface.ILocalize
import com.zippeykeys.praisebe.util.transferRegistryName
import it.unimi.dsi.fastutil.ints.Int2ObjectMap
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.world.World
import java.util.HashMap


open class PBBlock(private val name: String, materialIn: Material, color: MapColor = materialIn.materialMapColor,
        private val tileClass: Class<out PBTileEntity>? = null, creativeTab: CreativeTabs? = null) :
        BlockContainer(materialIn, color),
        ILocalize {
    val oreDictEntries: MutableMap<String, ItemStack> = HashMap()

    override val prefix: String
        get() = "tile"

    open val item: ItemBlock
        get() = transferRegistryName(ItemBlock(this), this)

    open val variants: Int2ObjectMap<String>
        get() {
            val variants = Int2ObjectOpenHashMap<String>()
            variants[0] = "inventory"
            return variants
        }

    open val tileEntity: Class<out PBTileEntity>?
        get() = tileClass

    init {
        @Suppress("LeakingThis")
        registryName = resource
        unlocalizedName = Reference.MOD_ID + "." + registryName!!.resourcePath
        if (creativeTab != null)
            this.setCreativeTab(creativeTab)
    }

    override fun getName(): String {
        return name
    }

    override fun getUnlocalizedName(): String {
        return super<ILocalize>.getUnlocalizedName()
    }

    override fun getLocalizedName(): String {
        return super<ILocalize>.getLocalizedName()
    }

    open fun addOreDictEntry(entry: String): PBBlock {
        oreDictEntries[entry] = ItemStack(this, 1, 0)
        return this
    }

    open fun addAllOreDictEntry(entriesIn: Collection<String>): PBBlock {
        for (entry in entriesIn) {
            addOreDictEntry(entry)
        }
        return this
    }

    override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? {
        val tile = tileEntity
        if (tile != null) {
            try {
                return tile.newInstance()
            } catch (ignored: InstantiationException) {
            } catch (ignored: IllegalAccessException) {
            }

        }
        return null
    }

    @Suppress("OverridingDeprecatedMember")
    override fun getRenderType(state: IBlockState): EnumBlockRenderType {
        return EnumBlockRenderType.MODEL
    }
}
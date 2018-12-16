package com.zippeykeys.praisebe.block.tile.base;

import org.jetbrains.annotations.NotNull;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public abstract class AbstractTileEntityIdolBase extends AbstractPBTileEntity implements ITickable {
    private int facing;

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        facing = tagCompound.getInteger("facing");
    }

    @Override
    public @NotNull NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("facing", facing);
        return tagCompound;
    }

    public int getFacing() {
        return facing;
    }

    public void setFacing(int face) {
        facing = face;
    }
}
package com.zippeykeys.praisebe.block.tile.base;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;


public class TileEntityIdolBase extends PBTileEntity implements ITickable{
    private int facing;

    @Override
    public void readFromNBT(NBTTagCompound tagCompound){
        super.readFromNBT(tagCompound);
        facing = tagCompound.getInteger("facing");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound){
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("facing", facing);
        return tagCompound;
    }

    public int getFacing(){
        return facing;
    }

    public void setFacing(int face){
        facing = face;
    }

    @Override
    public void update(){
    }
}
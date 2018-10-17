package com.zippeykeys.praisebe.common.tileentity;

import com.zippeykeys.praisebe.common.deity.IDeity;
import com.zippeykeys.praisebe.common.registry.DeityRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;


public class TileIdol extends TileEntity implements ITickable{
    private String deityId;
    private IDeity deity;

    public TileIdol(){
        this("");
    }

    public TileIdol(String deityName){
        deityId = deityName;
        deity = DeityRegistry.getDeity(deityId);
    }

    @Override
    public void update(){
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        deityId = compound.getString("deityID");
        deity = DeityRegistry.getDeity(deityId);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setString("deityID", deityId);
        return compound;
    }
}

package com.zippeykeys.praisebe.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.zippeykeys.praisebe.Reference;
import com.zippeykeys.praisebe.util.MathUtil;
import com.zippeykeys.praisebe.util.PlayerUtil;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.INBTSerializable;


public class DeityRegard implements INBTSerializable<NBTTagCompound>{
    private PBWorldData saver;

    private UUID uuid;

    private Map<String, Double> regards = new HashMap<>();

    public DeityRegard(NBTTagCompound nbt, PBWorldData saverIn){
        saver = saverIn;
        deserializeNBT(nbt);
    }

    public DeityRegard(EntityPlayer player, PBWorldData saverIn){
        this(PlayerUtil.getUUID(player), saverIn);
    }

    public DeityRegard(UUID uuidIn, @Nullable PBWorldData saverIn){
        uuid = uuidIn;
        saver = saverIn;
        Reference.INSTANCE.deityRegistry() //
          .keySet() //
          .forEach(this::addRegard);
    }

    public PBWorldData getSaver(){
        return saver;
    }

    public void setSaver(PBWorldData saverIn){
        saver = saverIn;
        markDirty();
    }

    public UUID getUUID(){
        return uuid;
    }

    public EntityPlayer getPlayer(){
        return PlayerUtil.getPlayer(uuid);
    }

    public @Nullable String getUsername(){
        return PlayerUtil.getUsername(uuid);
    }

    public void setPlayer(EntityPlayer player){
        setPlayer(PlayerUtil.getUUID(player));
    }

    public void setPlayer(UUID uuidIn){
        uuid = uuidIn;
        markDirty();
    }

    public double getRegard(ResourceLocation deity){
        return getRegard(deity.toString());
    }

    public double getRegard(String deity){
        return regards.get(deity);
    }

    public void addRegard(ResourceLocation deity){
        addRegard(deity.toString());
    }

    public void addRegard(ResourceLocation deity, double change){
        addRegard(deity.toString(), change);
    }

    public void addRegard(String deity){
        addRegard(deity, 0);
    }

    public void addRegard(String deity, double change){
        regards.put(deity, MathUtil.clamp(regards.get(deity) + change, -1, 1));
    }

    private void markDirty(){
        saver.markDirty();
    }

    @Override
    public NBTTagCompound serializeNBT(){
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setUniqueId("uuid", uuid);
        NBTTagList regData = new NBTTagList();
        regards.forEach((key, value) -> {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("name", key);
            compound.setDouble("regard", value);
            regData.appendTag(compound);
        });
        tagCompound.setTag("regards", regData);
        return tagCompound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt){
        uuid = nbt.getUniqueId("uuid");
        NBTTagList regData = nbt.getTagList("regards", 10);
        regData.forEach((tag) -> {
            NBTTagCompound tagCompound = (NBTTagCompound) tag;
            if(tagCompound == null){ return; }
            regards.put(tagCompound.getString("name"), tagCompound.getDouble("regard"));
        });
    }
}

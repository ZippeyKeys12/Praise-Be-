package com.zippeykeys.praisebe.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

@AllArgsConstructor
public class PlayerAttributes implements INBTSerializable<NBTTagCompound> {
    @UtilityClass
    public static class DEFAULTS {
        public static final int GRACE_TAINT = 0;
    }

    public static final int MAX = 100;
    public static final int MIN = -100;

    @Getter
    private int grace_taint;

    public PlayerAttributes() {
        this(DEFAULTS.GRACE_TAINT);
    }

    public PlayerAttributes(NBTTagCompound nbt) {
        deserializeNBT(nbt);
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setInteger("grace_taint", grace_taint);
        return tagCompound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        grace_taint = nbt.getInteger("grace_taint");
    }
}
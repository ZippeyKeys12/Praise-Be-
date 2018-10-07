package com.zippeykeys.praisebe.common.registry;

import com.zippeykeys.praisebe.common.deity.IDeity;

import java.util.HashMap;
import java.util.Map;


public class DeityRegistry{
    public static final Map<String, IDeity> DEITIES = new HashMap<>();

    public static void addDeity(IDeity deity, String id){
        DEITIES.put(id, deity);
    }

    public static void removeDeity(String id){
        DEITIES.remove(id);
    }
}

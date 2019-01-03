package com.zippeykeys.praisebe.registry;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.zippeykeys.praisebe.deity.Deity;
import com.zippeykeys.praisebe.util.Util;

import net.minecraftforge.registries.IForgeRegistry;


@Singleton
public class DeityRegistry extends PBRegistry<Deity>{
    @Inject
    @SuppressWarnings("deprecation")
    public DeityRegistry(IForgeRegistry<Deity> registryIn){
        super(Deity.Type.class, Deity.Element.class, Deity.Alignment.class);
        registryIn.getValues() //
          .forEach(this::register);
    }

    public Deity register(Deity value){
        return register(Util.getResource(value.getName()), value);
    }

    public Deity[] registerAll(Deity... values){
        return registerAll(Arrays.stream(values));
    }

    public Deity[] registerAll(Collection<? extends Deity> values){
        return registerAll(values.stream());
    }

    public Deity[] registerAll(Stream<? extends Deity> values){
        return values.map(this::register) //
          // .filter(Objects::nonNull) // Maybe shouldn't clean
          .toArray(Deity[]::new);
    }
}
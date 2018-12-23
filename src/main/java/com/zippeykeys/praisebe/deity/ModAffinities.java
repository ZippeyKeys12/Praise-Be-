package com.zippeykeys.praisebe.deity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ModAffinities {
    public static final Affinity APOLLO_GRANNUS = ImmutableAffinity.builder() //
            .name("apollogrannus") //
            .primaryDeity(ModDeities.Celestial.APOLLO) //
            .secondaryDeity(ModDeities.Terrestrial.GRANNUS) //
            .build();

    public static final Affinity AMUN_RA = ImmutableAffinity.builder() //
            .name("amunra") //
            .primaryDeity(ModDeities.Celestial.RA) //
            .secondaryDeity(ModDeities.Celestial.AMUN) //
            .build();

    public static final Affinity ZEUS_AMMON = ImmutableAffinity.builder() //
            .name("zeusammon"). //
            primaryDeity(ModDeities.Celestial.ZEUS) //
            .secondaryDeity(ModDeities.Celestial.AMUN) //
            .build();
}
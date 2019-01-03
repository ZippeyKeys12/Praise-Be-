package com.zippeykeys.praisebe.deity;

import lombok.experimental.UtilityClass;


@UtilityClass
public class ModAffinities{
    public static final Affinity APOLLO_GRANNUS = Affinity.builder() //
      .name("apollogrannus") //
      .primaryDeity(ModDeities.Celestial.APOLLO) //
      .secondaryDeity(ModDeities.Terrestrial.GRANNUS) //
      .build();

    public static final Affinity AMUN_RA = Affinity.builder() //
      .name("amunra") //
      .primaryDeity(ModDeities.Celestial.RA) //
      .secondaryDeity(ModDeities.Celestial.AMUN) //
      .build();

    public static final Affinity ZEUS_AMMON = Affinity.builder() //
      .name("zeusammon"). //
      primaryDeity(ModDeities.Celestial.ZEUS) //
      .secondaryDeity(ModDeities.Celestial.AMUN) //
      .build();
}
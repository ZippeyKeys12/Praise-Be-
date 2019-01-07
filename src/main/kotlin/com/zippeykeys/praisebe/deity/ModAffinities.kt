package com.zippeykeys.praisebe.deity

import com.zippeykeys.praisebe.deity.ModDeities.Celestial.AMUN
import com.zippeykeys.praisebe.deity.ModDeities.Celestial.APOLLO
import com.zippeykeys.praisebe.deity.ModDeities.Celestial.RA
import com.zippeykeys.praisebe.deity.ModDeities.Celestial.ZEUS
import com.zippeykeys.praisebe.deity.ModDeities.Terrestrial.GRANNUS

object ModAffinities {
    val APOLLO_GRANNUS = Affinity(
            name = "apollogrannus",
            primaryDeity = APOLLO,
            secondaryDeity = GRANNUS
    )

    val AMUN_RA = Affinity(
            name = "amunra",
            primaryDeity = RA,
            secondaryDeity = AMUN
    )

    val ZEUS_AMMON = Affinity(
            name = "zeusammon",
            primaryDeity = ZEUS,
            secondaryDeity = AMUN
    )
}
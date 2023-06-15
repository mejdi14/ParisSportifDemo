package com.net.core.network.model

import kotlinx.serialization.Serializable
import java.util.ArrayList

@Serializable
data class League(
    var leagues: ArrayList<LeagueData> = arrayListOf()
)
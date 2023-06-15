package com.net.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class LeagueData(
    var idLeague: String? = null,
    var strLeague: String? = null,
    var strSport: String? = null,
    var strLeagueAlternate: String? = null
)

package com.net.core.network

import com.net.core.network.model.League
import com.net.core.network.model.Teams

interface ParisSportifNetwork {

    suspend fun getLeagues(): League

    suspend fun getTeams(league: String): Teams
}

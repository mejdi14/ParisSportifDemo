package com.net.core.network.retrofit

import com.net.core.network.model.League
import com.net.core.network.model.Teams
import retrofit2.http.GET
import retrofit2.http.Query

interface ParisSportifRetrofitApi {
    @GET(value = "all_leagues.php")
    suspend fun getALLLeagues(): League

    @GET("search_all_teams.php")
    suspend fun getLeagueTeams(@Query("l") league: String): Teams

}

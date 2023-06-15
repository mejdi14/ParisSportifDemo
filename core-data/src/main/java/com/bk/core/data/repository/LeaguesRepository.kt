package com.bk.core.data.repository

import com.net.core.network.ParisSportifNetwork
import com.net.core.network.model.League
import javax.inject.Inject

open class LeaguesRepository @Inject constructor(
    private val network: ParisSportifNetwork
) {

    suspend fun getAllLeagues(): League {
        return network.getLeagues()
    }
}

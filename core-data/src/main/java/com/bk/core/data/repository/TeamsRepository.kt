package com.bk.core.data.repository

import com.net.core.network.model.Teams
import kotlinx.coroutines.flow.Flow

interface TeamsRepository {
    fun getTeamsStream(league: String): Flow<Result<Teams>>
}
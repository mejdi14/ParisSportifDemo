package com.bk.core.data.repository

import com.bk.core.data.ParisSportifDispatchers
import com.bk.core.data.Dispatcher
import com.net.core.network.ParisSportifNetwork
import com.net.core.network.model.Teams
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TeamsRepositoryImp @Inject constructor(
    @Dispatcher(ParisSportifDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val network: ParisSportifNetwork
) : TeamsRepository {

    override fun getTeamsStream(league: String): Flow<Result<Teams>> = flow {
        val teams = network.getTeams(league)
        val sortedFilteredTeams = teams.teams
            ?.sortedByDescending { it.strTeam }
            ?.filterIndexed { index, _ -> index % 2 == 0 }
            ?.toCollection(ArrayList())

        emit(Result.success(Teams(sortedFilteredTeams ?: arrayListOf())))
    }.flowOn(ioDispatcher)

}
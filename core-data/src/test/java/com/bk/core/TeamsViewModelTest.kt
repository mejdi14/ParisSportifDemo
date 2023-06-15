package com.bk.core

import com.bk.core.data.TeamsUiState
import com.bk.core.data.repository.TeamsRepository
import com.bk.core.data.viewmodel.TeamsViewModel
import com.net.core.network.model.TeamData
import com.net.core.network.model.Teams
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class TeamsViewModelTest {
    private lateinit var viewModel: TeamsViewModel
    private lateinit var repository: TeamsRepository

    @Before
    fun setup() {
        repository = mock()
        viewModel = TeamsViewModel(repository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getTeams should return expected result`() = runTest {
        val leagueName = "Test league"
        val expectedTeams = Teams(arrayListOf(
            TeamData(strTeam = "Team 1"),
            TeamData(strTeam = "Team 2"),
            TeamData(strTeam = "Team 3"),
            TeamData(strTeam = "Team 4")
        ))

        whenever(repository.getTeamsStream(leagueName)).thenReturn(flow {
            emit(Result.success(expectedTeams))
        })

        viewModel.fetchTeamsForLeague(leagueName)

        assertEquals(expectedTeams, (viewModel.teamsUiState.value as? TeamsUiState.Success)?.teams)
    }
}


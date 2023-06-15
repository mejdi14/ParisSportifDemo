package com.bk.core

import com.bk.core.data.repository.LeaguesRepository
import com.bk.core.data.viewmodel.LeagueViewModel
import com.net.core.network.ParisSportifNetwork
import com.net.core.network.model.League
import com.net.core.network.model.LeagueData
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class LeagueViewModelTest {
    private lateinit var viewModel: LeagueViewModel
    private lateinit var repository: LeaguesRepository

    @Before
    fun setup() {
        repository = mock()
        viewModel = LeagueViewModel(repository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getAllLeagues should return the expected data`() = runTest {
        // Given
        val expectedLeagues =
            League(arrayListOf(LeagueData("1", "League1"), LeagueData("2", "League2")))
        val mockNetwork: ParisSportifNetwork = mock()

        whenever(mockNetwork.getLeagues()).thenReturn(expectedLeagues)
        val repository = LeaguesRepository(mockNetwork)
        val viewModel = LeagueViewModel(repository)

        // When
        val result = viewModel.getAllLeagues()

        // Then
        assertEquals(expectedLeagues, result)
    }
}

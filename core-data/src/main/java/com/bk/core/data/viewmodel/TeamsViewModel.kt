package com.bk.core.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bk.core.data.ParisSportifDispatchers
import com.bk.core.data.Dispatcher
import com.bk.core.data.TeamsUiState
import com.bk.core.data.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val teamsRepository: TeamsRepository,
) :
    ViewModel() {

    @ExperimentalCoroutinesApi
    val teamsUiState: MutableStateFlow<TeamsUiState> = MutableStateFlow(TeamsUiState.Loading)

    @ExperimentalCoroutinesApi
    suspend fun fetchTeamsForLeague(leagueName: String) {
        teamsRepository.getTeamsStream(leagueName)
            .flatMapLatest {
                if (it.isSuccess) {
                    flowOf(TeamsUiState.Success(it.getOrThrow()))
                } else {
                    flowOf(TeamsUiState.Error)
                }
            }
            .collect { state ->
                teamsUiState.value = state
            }
    }
}

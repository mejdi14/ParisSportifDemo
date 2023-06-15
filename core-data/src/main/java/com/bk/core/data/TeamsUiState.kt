package com.bk.core.data

import com.net.core.network.model.Teams

sealed interface TeamsUiState {
    object Loading : TeamsUiState

    object Error : TeamsUiState

    data class Success(
        val teams: Teams
    ) : TeamsUiState
}

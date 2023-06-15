package com.bk.core.data.viewmodel

import androidx.lifecycle.ViewModel
import com.bk.core.data.repository.LeaguesRepository
import com.net.core.network.model.League
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
open class LeagueViewModel @Inject constructor(
    private val leaguesRepository: LeaguesRepository
) :
    ViewModel() {

    suspend fun getAllLeagues(): League {
        return leaguesRepository.getAllLeagues()
    }
}

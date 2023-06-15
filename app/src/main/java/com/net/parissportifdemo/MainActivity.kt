package com.net.parissportifdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bk.core.data.viewmodel.LeagueViewModel
import com.bk.core.data.viewmodel.TeamsViewModel
import com.net.core.network.model.LeagueData
import com.net.parissportifdemo.ui.components.AutoCompleteSearchBar
import com.net.parissportifdemo.ui.components.TeamImagesList
import com.net.parissportifdemo.ui.theme.ParisSportifTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Composable
    private fun MainContent(
        viewModel: LeagueViewModel = hiltViewModel(),
        teamsViewModel: TeamsViewModel = hiltViewModel()
    ) {
        var items by remember { mutableStateOf(listOf<LeagueData>()) }
        runBlocking {
            val leagueUiStateDeferred = async { viewModel.getAllLeagues().leagues }
            val leaguesUiState = leagueUiStateDeferred.await()
            items = leaguesUiState
        }
        val leagueName = remember { mutableStateOf("") }
        val teamsUiState by teamsViewModel.teamsUiState.collectAsState()

        LaunchedEffect(leagueName.value) {
            if (leagueName.value.isNotEmpty())
                teamsViewModel.fetchTeamsForLeague(leagueName.value)
        }

        Column {
            AutoCompleteSearchBar(items, leagueName) { selectedItem ->
                println("User selected $selectedItem")
            }
            TeamImagesList(teamsUiState)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParisSportifTheme {
    }
}

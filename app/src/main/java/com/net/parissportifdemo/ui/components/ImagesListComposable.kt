package com.net.parissportifdemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.bk.core.data.TeamsUiState

@Composable
fun TeamImagesList(teamsUiState: TeamsUiState) {
    val teams = when (teamsUiState) {
        is TeamsUiState.Success -> teamsUiState.teams.teams ?: listOf()
        else -> listOf()
    }

    LazyColumn {
        items(teams.chunked(2)) { rowTeams ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                rowTeams.forEach { team ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = team.strTeamBadge),
                            contentDescription = "Image of ${team.strTeam}",
                            modifier = Modifier.aspectRatio(1f),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}
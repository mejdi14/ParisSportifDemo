package com.net.parissportifdemo.ui.components

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.net.core.network.model.LeagueData
import com.net.parissportifdemo.MainActivity

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AutoCompleteSearchBar(
    items: List<LeagueData>,
    leagueName: MutableState<String>,
    onItemSelected: (String) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchQuery by remember { mutableStateOf("") }
    var suggestions by remember { mutableStateOf(listOf<LeagueData>()) }

    Column {
        BlurrySearchBar(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                suggestions = items.filter { item ->
                    (item.strLeague ?: "").contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            }
        )
        LazyColumn {
            items(suggestions) { suggestion ->
                Text(
                    text = suggestion.strLeague.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            searchQuery = suggestion.strLeague.toString()
                            leagueName.value =
                                suggestion.strLeague.toString()
                            onItemSelected(suggestion.strLeague.toString())
                            suggestions = listOf()
                            keyboardController?.hide()
                        }
                        .padding(10.dp)
                )
            }
        }
    }
}

package com.bk.feature2.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeRoute() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Text(text = "hello from home", modifier = Modifier.fillMaxSize())
}

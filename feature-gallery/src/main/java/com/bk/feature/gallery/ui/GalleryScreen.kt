package com.bk.feature.gallery.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun GalleryRoute() {
    GalleryScreen()
}

@Composable
fun GalleryScreen() {
    val navController = rememberNavController()
    Text(text = "hello from gallery", modifier = Modifier.fillMaxSize())
}

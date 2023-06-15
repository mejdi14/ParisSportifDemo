package com.bk.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bk.feature.gallery.ui.GalleryRoute

object GalleryDestination : ClassicArtNavigationDestination {
    override val route = "gallery_route"
    override val destination = "gallery_destination"
}

fun NavGraphBuilder.galleryGraph() {
    composable(route = GalleryDestination.route) {
        GalleryRoute()
    }
}

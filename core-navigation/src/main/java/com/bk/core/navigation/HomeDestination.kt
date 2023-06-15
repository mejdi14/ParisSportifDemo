package com.bk.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bk.feature2.home.ui.HomeRoute

object HomeDestination : ClassicArtNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph() {
    composable(route = HomeDestination.route) {
        HomeRoute()
    }
}

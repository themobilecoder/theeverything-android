package com.themobilecoder.images_demo.internal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.images_demo.internal.ui.screens.ImagesDemoListScreen
import com.themobilecoder.images_demo.internal.ui.screens.listdetail.AnimatedTransitionGridListScreen
import com.themobilecoder.images_demo.internal.ui.screens.local.LocalImageScreen
import com.themobilecoder.images_demo.internal.ui.screens.network.NetworkImageScreen


internal object ImagesDemoDestinations {
    const val HOME = "/"
    const val NETWORK = "network"
    const val LOCAL = "local"
    const val GRID = "grid"
}

@Composable
internal fun ImagesDemoNavGraph(
    onFinish: () -> Unit,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = ImagesDemoDestinations.HOME,
    ) {
        composable(ImagesDemoDestinations.HOME) {
            ImagesDemoListScreen(
                navController = navController,
                onBackButtonPressed = onFinish
            )
        }
        composable(ImagesDemoDestinations.NETWORK) {
            NetworkImageScreen(
                navController = navController,
            )
        }
        composable(ImagesDemoDestinations.LOCAL) {
            LocalImageScreen(
                navController = navController,
            )
        }
        composable(ImagesDemoDestinations.GRID) {
            AnimatedTransitionGridListScreen(
                navController = navController,
            )
        }
    }
}


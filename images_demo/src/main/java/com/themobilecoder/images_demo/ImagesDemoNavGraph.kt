package com.themobilecoder.images_demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.images_demo.ImagesDemoMetadata.ImagesDemoDestination.IMAGES_DEMO_ROUTE
import com.themobilecoder.images_demo.ui.screens.ImagesDemoListScreen
import com.themobilecoder.images_demo.ui.screens.local.ImagesDemoLocalScreen
import com.themobilecoder.images_demo.ui.screens.network.ImagesDemoNetworkScreen


fun NavGraphBuilder.imagesDemoActivityEntryPoint() {
    activity(route = IMAGES_DEMO_ROUTE) {
        activityClass = ImagesDemoActivity::class
    }
}

@Composable
fun ImagesDemoActivityNavGraph(
    onFinish: () -> Unit,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "/"
    ) {
        composable("/") {
            ImagesDemoListScreen(
                navController = navController,
                onBackButtonPressed = onFinish
            )
        }
        composable("network") {
            ImagesDemoNetworkScreen(
                navController = navController,
            )
        }
        composable("local") {
            ImagesDemoLocalScreen(
                navController = navController,
            )
        }
    }
}


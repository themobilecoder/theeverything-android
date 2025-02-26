package com.themobilecoder.images_demo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.images_demo.ImagesDemoMetadata.ImagesDemoDestination.IMAGES_DEMO_ROUTE


fun NavGraphBuilder.imagesDemoActivityEntryPoint() {
    activity(route = IMAGES_DEMO_ROUTE) {
        activityClass = ImagesDemoActivity::class
    }
}

@Composable
fun ImagesDemoActivityNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "/"
    ) {
        composable("/") {
            Text(
                text = "Images Demo",
            )

        }
    }
}


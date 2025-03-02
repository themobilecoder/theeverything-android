package com.themobilecoder.theeverythingandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.images_demo.imagesDemoActivityEntryPoint
import com.themobilecoder.snackbar_demo.snackbarDemoActivityEntryPoint
import com.themobilecoder.tab_demo.navigation.tabDemoActivityEntryPoint
import com.themobilecoder.theeverythingandroid.ui.home.HomeScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HOME
    ) {
        homeComposableEntryPoint(navController)
        snackbarDemoActivityEntryPoint()
        imagesDemoActivityEntryPoint()
        tabDemoActivityEntryPoint()
    }
}

private fun NavGraphBuilder.homeComposableEntryPoint(
    navController: NavHostController,
) {
    composable(HOME) {
        HomeScreen(navController)
    }
}

private const val HOME = "/"

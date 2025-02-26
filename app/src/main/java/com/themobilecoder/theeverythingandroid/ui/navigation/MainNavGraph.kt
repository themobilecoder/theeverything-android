package com.themobilecoder.theeverythingandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.images_demo.imagesDemoActivityEntryPoint
import com.themobilecoder.snackbar_demo.ui.snackbarDemoActivityEntryPoint
import com.themobilecoder.tab_demo.navigation.navGraphTabDemo
import com.themobilecoder.theeverythingandroid.ui.home.HomeScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HOME
    ) {
        composable(HOME) {
            HomeScreen(navController)
        }
        snackbarDemoActivityEntryPoint()
        imagesDemoActivityEntryPoint()
        navGraphTabDemo(navController)
    }
}

private const val HOME = "/"

package com.themobilecoder.theeverythingandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.snackbar_demo.navHostSnackbarDemo
import com.themobilecoder.theeverythingandroid.ui.home.HomeScreen

@Composable
fun NavHostMain(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME
    ) {
        composable(HOME) {
            HomeScreen(navController)
        }
        navHostSnackbarDemo(navController)
    }
}

private const val HOME = "/"

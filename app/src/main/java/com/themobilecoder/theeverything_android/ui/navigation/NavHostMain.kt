package com.themobilecoder.theeverything_android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.themobilecoder.theeverything_android.ui.destination.DestinationScreen
import com.themobilecoder.theeverything_android.ui.home.HomeScreen

@Composable
fun NavHostMain(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("destination/{args}",
            arguments = listOf(
                navArgument("args") {
                    type = NavType.StringType
                }
            )
        ) {
            DestinationScreen()
        }
    }
}
package com.themobilecoder.snackbar_demo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.themobilecoder.snackbar_demo.SnackbarDemoDestination.SNACKBAR_DEMO_ROUTE

fun NavGraphBuilder.navHostSnackbarDemo(
    navController: NavHostController
) {
    navigation(route = SNACKBAR_DEMO_ROUTE, startDestination = SNACKBAR_DEMO_HOME) {
        composable(SNACKBAR_DEMO_HOME) {
            SnackbarDemoScreen(
                onBackButtonPressed = {
                    navController.navigateUp()
                }
            )
        }
    }
}

private const val SNACKBAR_DEMO_HOME = "/"

object SnackbarDemoDestination {
    const val SNACKBAR_DEMO_ROUTE = "snackbarDemo"
}
package com.themobilecoder.snackbar_demo.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.themobilecoder.snackbar_demo.SNACKBAR_DEMO_HOME
import com.themobilecoder.snackbar_demo.SnackbarDemoDestination.SNACKBAR_DEMO_ROUTE
import com.themobilecoder.snackbar_demo.screen.SnackbarDemoScreen

fun NavGraphBuilder.navigationHostSnackbarDemo(
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


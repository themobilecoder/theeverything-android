package com.themobilecoder.snackbar_demo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.snackbar_demo.SNACKBAR_DEMO_HOME
import com.themobilecoder.snackbar_demo.SnackbarDemoDestination.SNACKBAR_DEMO_ROUTE

fun NavGraphBuilder.snackbarDemoActivityEntryPoint() {
    activity(route = SNACKBAR_DEMO_ROUTE) {
        activityClass = SnackbarDemoActivity::class
    }
}

@Composable
fun SnackbarDemoActivityNavGraph(
    navController: NavHostController,
    onToolbarBackButtonClicked: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = SNACKBAR_DEMO_HOME
    ) {
        composable(SNACKBAR_DEMO_HOME) {
            SnackbarDemoScreen(
                onBackButtonPressed = {
                    onToolbarBackButtonClicked()
                }
            )
        }
    }
}


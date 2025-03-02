package com.themobilecoder.snackbar_demo.internal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.snackbar_demo.internal.ui.SnackbarDemoScreen

@Composable
internal fun SnackbarDemoActivityNavGraph(
    navController: NavHostController,
    onToolbarBackButtonClicked: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = "/"
    ) {
        composable("/") {
            SnackbarDemoScreen(
                onBackButtonPressed = {
                    onToolbarBackButtonClicked()
                }
            )
        }
    }
}


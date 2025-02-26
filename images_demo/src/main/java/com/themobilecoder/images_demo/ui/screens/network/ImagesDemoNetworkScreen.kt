package com.themobilecoder.images_demo.ui.screens.network

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar

@Composable
fun ImagesDemoNetworkScreen(
    navController: NavController,
) {
    BasicScaffoldWithTopBar(
        title = "Network Images",
        onBackButtonPressed = { navController.popBackStack() },
    ) { paddingValues ->
        Text(
            text = "Network",
            modifier = Modifier.padding(paddingValues),
        )
    }
}
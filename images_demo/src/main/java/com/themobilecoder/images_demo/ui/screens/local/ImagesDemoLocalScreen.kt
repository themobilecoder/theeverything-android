package com.themobilecoder.images_demo.ui.screens.local

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar

@Composable
fun ImagesDemoLocalScreen(
    navController: NavController,
) {
    BasicScaffoldWithTopBar(
        title = "Local Images",
        onBackButtonPressed = { navController.popBackStack() },
    ) { paddingValues ->
        Text(
            text = "Local",
            modifier = Modifier.padding(paddingValues),
        )
    }
}
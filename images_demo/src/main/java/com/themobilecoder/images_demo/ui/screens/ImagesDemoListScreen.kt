package com.themobilecoder.images_demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.core.ui.list.ListItemWithDescription

@Composable
fun ImagesDemoListScreen(
    navController: NavController,
    onBackButtonPressed: () -> Unit = {},
) {
    BasicScaffoldWithTopBar(
        title = "Images Demo",
        onBackButtonPressed = { onBackButtonPressed() },
    ) {
        Column(Modifier.padding(it)) {
            ListItemWithDescription(
                title = "Local",
                description = "Load images from local storage",
            ) {
                navController.navigate("local")
            }
            ListItemWithDescription(
                title = "Network",
                description = "Load images from network",
            ) {
                navController.navigate("network")
            }
        }
    }
}

@Preview
@Composable
private fun ImagesDemoScreenPreview() {
    ImagesDemoListScreen(
        navController = rememberNavController(),
    )
}
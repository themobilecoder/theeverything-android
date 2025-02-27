package com.themobilecoder.images_demo.internal.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.core.ui.list.ListItemWithDescription
import com.themobilecoder.images_demo.internal.ImagesDemoDestinations

@Composable
internal fun ImagesDemoListScreen(
    navController: NavController,
    onBackButtonPressed: () -> Unit = {},
) {
    BasicScaffoldWithTopBar(
        title = "Images Demo",
        onBackButtonPressed = { onBackButtonPressed() },
    ) {
        Column(Modifier.padding(it)) {
            ListItemWithDescription(
                title = "Local using Image Painter",
                description = "Load images from local storage",
            ) {
                navController.navigate(ImagesDemoDestinations.LOCAL)
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = colorScheme.outline.copy(
                    alpha = 0.1f
                )
            )
            ListItemWithDescription(
                title = "Network using Coil",
                description = "Fetch an image from network",
            ) {
                navController.navigate(ImagesDemoDestinations.NETWORK)
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = colorScheme.outline.copy(
                    alpha = 0.1f
                )
            )
            ListItemWithDescription(
                title = "Grid Images with preview using Coil",
                description = "Fetch multiple images (1025) from network",
            ) {
                navController.navigate(ImagesDemoDestinations.GRID)
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
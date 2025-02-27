package com.themobilecoder.images_demo.internal.ui.screens.local

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.images_demo.R

@Composable
internal fun LocalImageScreen(
    navController: NavController,
) {
    BasicScaffoldWithTopBar(
        title = "Local Image",
        onBackButtonPressed = { navController.navigateUp() },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.undraw_local_image),
                contentDescription = "Local Image",
            )
        }
    }
}
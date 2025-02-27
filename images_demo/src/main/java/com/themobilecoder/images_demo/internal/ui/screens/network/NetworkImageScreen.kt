package com.themobilecoder.images_demo.internal.ui.screens.network

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.images_demo.internal.ui.components.NetworkImageContainer

@Composable
internal fun NetworkImageScreen(
    navController: NavController,
) {
    BasicScaffoldWithTopBar(
        title = "Network Image",
        onBackButtonPressed = { navController.navigateUp() },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            NetworkImageContainer(
                modifier = Modifier.size(256.dp),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/25.png",
                contentDescription = "Network Image",
            )
        }

    }
}
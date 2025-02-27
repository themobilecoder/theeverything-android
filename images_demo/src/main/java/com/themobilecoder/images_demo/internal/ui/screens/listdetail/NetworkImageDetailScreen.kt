package com.themobilecoder.images_demo.internal.ui.screens.listdetail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.images_demo.internal.ui.components.NetworkImageContainer

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun NetworkImageDetailScreen(
    imageId: Int,
    baseImageUrl: String,
    onBackButtonPressed: () -> Unit,
    animatedContentScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
) {
    BackHandler { onBackButtonPressed() }
    BasicScaffoldWithTopBar(
        title = "Image Detail",
        onBackButtonPressed = onBackButtonPressed,
    ) { paddingValues ->
        with(sharedTransitionScope) {
            NetworkImageContainer(
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "key-$imageId"),
                        animatedVisibilityScope = animatedContentScope
                    )
                    .fillMaxSize()
                    .padding(paddingValues),
                onClick = {
                    onBackButtonPressed()
                },
                imageUrl = "$baseImageUrl$imageId.png",
                key = "key-$imageId",
                contentDescription = "Image #$imageId",
            )
        }
    }
}
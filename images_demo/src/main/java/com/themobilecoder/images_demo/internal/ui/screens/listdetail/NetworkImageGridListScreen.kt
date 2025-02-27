package com.themobilecoder.images_demo.internal.ui.screens.listdetail

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.images_demo.internal.ui.components.NetworkImageContainer

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun NetworkImageGridListScreen(
    baseImageUrl: String,
    imageCountFromUrl: Int,
    gridState: LazyGridState,
    onBackButtonPressed: () -> Unit,
    onSelectImage: (Int) -> Unit,
    animatedContentScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
) {
    BasicScaffoldWithTopBar(
        title = "Grid Thumbnail",
        onBackButtonPressed = onBackButtonPressed,
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier.padding(paddingValues),
            state = gridState,
            columns = GridCells.Fixed(2),
        ) {
            items(imageCountFromUrl) { index ->
                val imageNumber = index + 1
                with(sharedTransitionScope) {
                    NetworkImageContainer(
                        modifier = Modifier
                            .sharedElement(
                                rememberSharedContentState(key = "key-$imageNumber"),
                                animatedVisibilityScope = animatedContentScope,
                            )
                            .height(128.dp),
                        onClick = {
                            onSelectImage(imageNumber)
                        },
                        imageUrl = "$baseImageUrl$imageNumber.png",
                        key = "key-$imageNumber",
                        contentDescription = "Image #$imageNumber",
                    )
                }

            }
        }
    }
}
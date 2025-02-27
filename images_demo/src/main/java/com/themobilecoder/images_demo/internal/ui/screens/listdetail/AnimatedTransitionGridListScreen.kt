@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.themobilecoder.images_demo.internal.ui.screens.listdetail

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController


@Composable
internal fun AnimatedTransitionGridListScreen(
    navController: NavController,
) {
    var selectedImageId by remember { mutableStateOf<Int?>(null) }
    val gridState = rememberLazyGridState()
    SharedTransitionLayout {
        AnimatedContent(
            targetState = selectedImageId,
            label = "basic_image_list_detail_transition",
        ) { imageId ->
            if (imageId == null) {
                NetworkImageGridListScreen(
                    imageCountFromUrl = POKEMON_COUNT,
                    baseImageUrl = IMG_LINK,
                    gridState = gridState,
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    onSelectImage = {
                        selectedImageId = it
                    },
                    animatedContentScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout,
                )
            } else {
                NetworkImageDetailScreen(
                    imageId = imageId,
                    baseImageUrl = IMG_LINK,
                    onBackButtonPressed = {
                        selectedImageId = null
                    },
                    animatedContentScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout,
                )
            }
        }
    }
}

private const val POKEMON_COUNT = 1025
private const val IMG_LINK =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/"
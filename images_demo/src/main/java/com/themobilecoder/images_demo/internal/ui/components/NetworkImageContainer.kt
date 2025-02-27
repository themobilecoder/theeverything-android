package com.themobilecoder.images_demo.internal.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
internal fun NetworkImageContainer(
    modifier: Modifier = Modifier,
    imageUrl: String,
    key: String? = null,
    onClick: () -> Unit = {},
    contentDescription: String,
) {
    SubcomposeAsyncImage(
        modifier = modifier
            .clickable { onClick() },
        loading = {
            Box(
                modifier = Modifier
                    .size(24.dp), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = colorScheme.primary,
                    strokeWidth = 4.dp
                )
            }
        },
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .placeholderMemoryCacheKey(key)
            .memoryCacheKey(key)
            .build(),
        contentDescription = contentDescription,
    )
}
package com.themobilecoder.images_demo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import com.themobilecoder.core.FeatureMetadata
import com.themobilecoder.images_demo.ImagesDemoMetadata.ImagesDemoDestination.IMAGES_DEMO_ROUTE

object ImagesDemoMetadata : FeatureMetadata {
    override val featureData: FeatureMetadata.FeatureData
        get() = FeatureMetadata.FeatureData(
            title = "Images",
            description = "Simple demonstration of using images in Jetpack Compose",
            destination = IMAGES_DEMO_ROUTE,
            tags = listOf("images", "flow", "coil", "painter", "glide", "animation"),
        )

    internal object ImagesDemoDestination {
        const val IMAGES_DEMO_ROUTE = "imagesDemo"
    }
}

fun NavGraphBuilder.imagesDemoActivityEntryPoint() {
    activity(route = IMAGES_DEMO_ROUTE) {
        activityClass = ImagesDemoActivity::class
    }
}
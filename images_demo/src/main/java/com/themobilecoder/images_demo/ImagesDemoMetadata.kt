package com.themobilecoder.images_demo

import com.themobilecoder.core.FeatureMetadata
import com.themobilecoder.images_demo.ImagesDemoMetadata.ImagesDemoDestination.IMAGES_DEMO_ROUTE

object ImagesDemoMetadata : FeatureMetadata {
    override val featureData: FeatureMetadata.FeatureData
        get() = FeatureMetadata.FeatureData(
            title = "Images",
            description = "Simple demonstration of using images",
            destination = IMAGES_DEMO_ROUTE,
            tags = listOf("images", "flow", "coil", "painter", "glide"),
        )

    internal object ImagesDemoDestination {
        const val IMAGES_DEMO_ROUTE = "imagesDemo"
    }

}
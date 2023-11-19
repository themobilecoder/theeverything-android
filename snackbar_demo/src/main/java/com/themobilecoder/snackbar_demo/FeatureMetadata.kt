package com.themobilecoder.snackbar_demo

interface FeatureMetadata {
    data class FeatureData(
        val title: String,
        val destination: String,
        val description: String
    )

    val featureData: FeatureData
}
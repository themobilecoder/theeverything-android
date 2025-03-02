package com.themobilecoder.snackbar_demo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import com.themobilecoder.core.FeatureMetadata
import com.themobilecoder.snackbar_demo.SnackbarDemoDestination.SNACKBAR_DEMO_ROUTE

object SnackbarFeatureMetadata : FeatureMetadata {
    override val featureData: FeatureMetadata.FeatureData
        get() = FeatureMetadata.FeatureData(
            title = "Snackbar",
            description = "Simple demonstration of using snackbar",
            destination = SNACKBAR_DEMO_ROUTE,
            tags = listOf("snackbar", "flow", "shared flow"),
        )
}

fun NavGraphBuilder.snackbarDemoActivityEntryPoint() {
    activity(route = SNACKBAR_DEMO_ROUTE) {
        activityClass = SnackbarDemoActivity::class
    }
}

internal object SnackbarDemoDestination {
    const val SNACKBAR_DEMO_ROUTE = "snackbarDemo"
}
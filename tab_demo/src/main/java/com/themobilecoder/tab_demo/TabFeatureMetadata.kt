package com.themobilecoder.tab_demo

import com.themobilecoder.core.FeatureMetadata
import com.themobilecoder.tab_demo.TabDemoDestination.TAB_DEMO_ROUTE

object TabFeatureMetadata : FeatureMetadata {
    override val featureData: FeatureMetadata.FeatureData
        get() = FeatureMetadata.FeatureData(
            title = "Horizontal Pager and Tabs",
            description = "Demonstration of using Tabs in Compose",
            destination = TAB_DEMO_ROUTE,
            tags = listOf("tabs", "pager", "horizontal pager", "tab", "tab row", "row"),
        )
}

internal const val TAB_DEMO_HOME = "/"

internal object TabDemoDestination {
    const val TAB_DEMO_ROUTE = "tabDemo"
}
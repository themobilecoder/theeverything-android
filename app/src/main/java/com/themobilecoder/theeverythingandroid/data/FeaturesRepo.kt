package com.themobilecoder.theeverythingandroid.data

import com.themobilecoder.images_demo.ImagesDemoMetadata
import com.themobilecoder.snackbar_demo.SnackbarFeatureMetadata
import com.themobilecoder.tab_demo.TabFeatureMetadata
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FeaturesRepo @Inject constructor() {

    private val featureMetadataList = listOf(
        TabFeatureMetadata,
        ImagesDemoMetadata,
        SnackbarFeatureMetadata,
    )

    val featuresFlow: Flow<List<Feature>> = MutableStateFlow(
        featureMetadataList.map {
            val featureData = it.featureData
            Feature(
                title = featureData.title,
                destination = featureData.destination,
                description = featureData.description,
                tags = featureData.tags
            )
        }
    )
}
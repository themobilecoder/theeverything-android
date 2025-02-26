package com.themobilecoder.theeverythingandroid.ui.home

import androidx.lifecycle.ViewModel
import com.themobilecoder.core.FeatureMetadata
import com.themobilecoder.images_demo.ImagesDemoMetadata
import com.themobilecoder.snackbar_demo.SnackbarFeatureMetadata
import com.themobilecoder.tab_demo.TabFeatureMetadata
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _destinationState = MutableSharedFlow<String>(
        extraBufferCapacity = 1
    )
    val destinationState: SharedFlow<String> = _destinationState

    private val _uiState = MutableStateFlow(
        HomeScreenUiState(
            destinations = listOf(
                SnackbarFeatureMetadata,
                TabFeatureMetadata,
                ImagesDemoMetadata
            )
        )
    )
    val uiState: StateFlow<HomeScreenUiState> = _uiState

    fun navigateToFeature(destinationRoute: String) {
        _destinationState.tryEmit(destinationRoute)
    }

    data class HomeScreenUiState(
        val destinations: List<FeatureMetadata>
    )
}
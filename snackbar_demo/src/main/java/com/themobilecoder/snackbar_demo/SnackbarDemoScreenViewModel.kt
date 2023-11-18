package com.themobilecoder.snackbar_demo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class SnackbarDemoScreenViewModel @Inject constructor(): ViewModel() {

    private val _snackbarSharedFlow = MutableSharedFlow<SnackbarType>(extraBufferCapacity = 1)
    val snackbarSharedFlow: SharedFlow<SnackbarType> = _snackbarSharedFlow

    fun onShowStandardSnackbar() {
        _snackbarSharedFlow.tryEmit(SnackbarType.STANDARD_SNACKBAR)
    }

    fun onShowSnackbarWithButton() {
        _snackbarSharedFlow.tryEmit(SnackbarType.SNACKBAR_WITH_BUTTON)
    }
}
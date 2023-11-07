package com.themobilecoder.theeverything_android.ui.home

sealed class HomeScreenDestinationState {
    object Home : HomeScreenDestinationState()
    class Destination(val args: String) : HomeScreenDestinationState()
}
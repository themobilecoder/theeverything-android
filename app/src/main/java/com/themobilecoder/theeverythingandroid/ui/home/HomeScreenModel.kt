package com.themobilecoder.theeverythingandroid.ui.home

sealed class HomeScreenDestinationState {
    object Home : HomeScreenDestinationState()
    class Destination(val args: String) : HomeScreenDestinationState()
}
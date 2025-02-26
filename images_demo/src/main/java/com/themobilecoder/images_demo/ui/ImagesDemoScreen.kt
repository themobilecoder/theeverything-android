package com.themobilecoder.images_demo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar

@Composable
fun ImagesDemoScreen(
    onBackButtonPressed: () -> Unit = {},
) {
    BasicScaffoldWithTopBar(
        title = "Images Demo",
        onBackButtonPressed = { onBackButtonPressed() },
    ) {
        Column(Modifier.padding(it)) {
        }
    }
}

@Preview
@Composable
private fun ImagesDemoScreenPreview() {
    ImagesDemoScreen()
}
package com.themobilecoder.snackbar_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.themobilecoder.snackbar_demo.internal.SnackbarDemoActivityNavGraph
import com.themobilecoder.snackbar_demo.internal.ui.theme.SnackbarDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SnackbarDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            SnackbarDemoTheme {
                SnackbarDemoActivityNavGraph(
                    navController = navHostController,
                    onToolbarBackButtonClicked = { finish() }
                )
            }
        }
    }
}
package com.themobilecoder.images_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.themobilecoder.images_demo.ui.theme.ImagesDemoTheme

class ImagesDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ImagesDemoTheme {
                ImagesDemoActivityNavGraph(
                    navController = navController,
                    onFinish = { finish() }
                )
            }
        }
    }
}
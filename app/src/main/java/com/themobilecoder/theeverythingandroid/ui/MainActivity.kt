package com.themobilecoder.theeverythingandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.themobilecoder.theeverythingandroid.ui.config.TheEverythingAndroidTheme
import com.themobilecoder.theeverythingandroid.ui.navigation.NavHostMain
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            TheEverythingAndroidTheme(dynamicColor = false) {
                Surface {
                    NavHostMain(navController = navController)
                }
            }
        }
    }
}
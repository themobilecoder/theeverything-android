package com.themobilecoder.theeverything_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.themobilecoder.theeverything_android.ui.theme.TheEverythingAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheEverythingAndroidTheme(dynamicColor = false) {


            }
        }
    }
}
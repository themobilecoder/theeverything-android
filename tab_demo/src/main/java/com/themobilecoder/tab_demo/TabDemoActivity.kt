package com.themobilecoder.tab_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.themobilecoder.tab_demo.navigation.TabDemoActivityNavGraph
import com.themobilecoder.tab_demo.ui.theme.TheEverythingAndroidTheme

class TabDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheEverythingAndroidTheme {
                TabDemoActivityNavGraph(
                    onFinish = { finish() },
                    navController = rememberNavController()
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheEverythingAndroidTheme {
        Greeting("Android")
    }
}
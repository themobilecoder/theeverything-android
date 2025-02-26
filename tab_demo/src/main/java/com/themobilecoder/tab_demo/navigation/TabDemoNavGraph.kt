package com.themobilecoder.tab_demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.themobilecoder.tab_demo.TabDemoActivity
import com.themobilecoder.tab_demo.navigation.TabDemoDestination.TAB_DEMO_ROUTE
import com.themobilecoder.tab_demo.screen.TabFeatureDemoScreen

fun NavGraphBuilder.tabDemoActivityEntryPoint() {
    activity(route = TAB_DEMO_ROUTE) {
        activityClass = TabDemoActivity::class
    }
}

@Composable
fun TabDemoActivityNavGraph(
    onFinish: () -> Unit,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = TAB_DEMO_HOME
    ) {
        composable(TAB_DEMO_HOME) {
            TabFeatureDemoScreen(
                onBackButtonPressed = onFinish
            )
        }
    }
}

internal const val TAB_DEMO_HOME = "/"

internal object TabDemoDestination {
    const val TAB_DEMO_ROUTE = "tabDemo"
}
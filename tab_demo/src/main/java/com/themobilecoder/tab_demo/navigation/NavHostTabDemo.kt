package com.themobilecoder.tab_demo.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.themobilecoder.tab_demo.TAB_DEMO_HOME
import com.themobilecoder.tab_demo.TabDemoDestination.TAB_DEMO_ROUTE
import com.themobilecoder.tab_demo.screen.TabFeatureDemoScreen


fun NavGraphBuilder.navGraphTabDemo(
    navController: NavHostController,
) {
    navigation(route = TAB_DEMO_ROUTE, startDestination = TAB_DEMO_HOME) {
        composable(TAB_DEMO_HOME) {
            TabFeatureDemoScreen(navController)
        }
    }
}


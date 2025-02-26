package com.themobilecoder.tab_demo.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.tab_demo.screen.tabs.ScreenOne
import com.themobilecoder.tab_demo.screen.tabs.ScreenThree
import com.themobilecoder.tab_demo.screen.tabs.ScreenTwo
import kotlinx.coroutines.launch

@Composable
fun TabFeatureDemoScreen(
    onBackButtonPressed: () -> Unit,
) {
    BasicScaffoldWithTopBar(
        title = "Tabs Demo",
        onBackButtonPressed = onBackButtonPressed,
    ) { paddingValues ->
        var tabIndex by remember { mutableIntStateOf(0) }
        val pagerState = rememberPagerState(
            pageCount = { 3 }
        )
        val scope = rememberCoroutineScope()
        Column(Modifier.padding(paddingValues)) {
            TabRow(
                selectedTabIndex = tabIndex,
            ) {
                Tab(
                    text = { Text("Screen 1") },
                    selected = tabIndex == 0,
                    onClick = {
                        tabIndex = 0
                        scope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    }
                )
                Tab(
                    text = { Text("Screen 2") },
                    selected = tabIndex == 1,
                    onClick = {
                        tabIndex = 1
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                )
                Tab(
                    text = { Text("Screen 3") },
                    selected = tabIndex == 2,
                    onClick = {
                        tabIndex = 2
                        scope.launch {
                            pagerState.animateScrollToPage(2)
                        }
                    }
                )
            }
            HorizontalPager(
                state = pagerState,
            ) { pagerIndex ->
                tabIndex = pagerState.currentPage
                when (pagerIndex) {
                    0 -> ScreenOne()
                    1 -> ScreenTwo()
                    2 -> ScreenThree()
                    else -> ScreenOne()
                }
            }

        }
    }
}

@Preview
@Composable
private fun TabFeatureDemoScreenPreview() {
    TabFeatureDemoScreen(
        onBackButtonPressed = {},
    )
}
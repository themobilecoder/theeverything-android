@file:OptIn(ExperimentalCoroutinesApi::class)

package com.themobilecoder.snackbar_demo.internal.ui

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SnackbarDemoScreenViewModelTest {

    private val viewModel = SnackbarDemoScreenViewModel()

    @Test
    fun `should show standard snackbar`() = runTest(UnconfinedTestDispatcher()) {
        val sharedFlow = viewModel.snackbarSharedFlow

        val deferred = async {
            sharedFlow.first()
        }

        viewModel.onShowStandardSnackbar()

        assertEquals(SnackbarType.STANDARD_SNACKBAR, deferred.await())
    }

    @Test
    fun `should show snackbar with button`() = runTest(UnconfinedTestDispatcher()) {
        val sharedFlow = viewModel.snackbarSharedFlow

        val deferred = async {
            sharedFlow.first()
        }

        viewModel.onShowSnackbarWithButton()

        assertEquals(SnackbarType.SNACKBAR_WITH_BUTTON, deferred.await())
    }
}
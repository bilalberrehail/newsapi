package com.example.instantsystemtest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.instantsystemtest.business.models.News
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NewsViewModelTest {

    private lateinit var viewModel: NewsViewModel

    @Before
    fun setup() {
        viewModel = NewsViewModel(
            News(
                title = "Titre",
                description = "Description",
                urlImage = "urlImage",
                url = "url"
            )
        )
    }

    @Test
    fun `When see more button is clicked, we update the action state`() = runTest {
        // Then
        viewModel.actions.test {
            assertTrue(awaitItem() is NewsViewModel.Action.None)
            viewModel.onSeeMoreClicked()
            assertEquals(viewModel.news.url, (awaitItem() as NewsViewModel.Action.OpenUrl).url)
        }
    }

    @Test
    fun `When action is performed, we reset action state`() = runTest {
        // Given
        viewModel.onSeeMoreClicked()

        // Then
        viewModel.actions.test {
            assertTrue(awaitItem() is NewsViewModel.Action.OpenUrl)
            viewModel.onActionPerformed()
            assertTrue(awaitItem() is NewsViewModel.Action.None)
        }
    }
}
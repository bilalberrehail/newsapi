package com.example.instantsystemtest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.business.repositories.NewsRepository
import com.example.instantsystemtest.utils.KDispatchers
import junit.framework.TestCase
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.mockito.Mockito.mock
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class HomeViewModelTest : KoinTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val repository: NewsRepository = mock()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        startKoin {
            modules(
                module {
                    single<KDispatchers> {
                        KTestDispatchers()
                    }
                })
        }
        createViewModel()
    }

    @After
    fun setDown() {
        stopKoin()
    }

    @Test
    fun `When view model is initialized, news are automatically retrieved`() = runTest {
        // Given
        val listNews = listOf(
            News(
                title = "Titre",
                description = "Description",
                urlImage = "urlImage",
                url = "url"
            )
        )
        whenever(repository.getNews()).doReturn(listNews)

        // When
        createViewModel()

        // Then
        viewModel.screenState.test {
            assertTrue(awaitItem() is HomeViewModel.ScreenState.Success)
            cancelAndIgnoreRemainingEvents()
        }

        assertEquals(listNews, viewModel.listNews.value)
    }

    @Test
    fun `When retrieving news failed, an error screen state is updated`() = runTest {
        // Given
        whenever(repository.getNews()).doAnswer { throw Exception() }

        // When
        createViewModel()

        // Then
        viewModel.screenState.test {
            assertTrue(awaitItem() is HomeViewModel.ScreenState.ErrorRetrievingNews)
            cancelAndIgnoreRemainingEvents()
        }

        assertTrue(viewModel.listNews.value?.isEmpty() == true)
    }

    @Test
    fun `When a news is clicked, we update the action to navigate user to the screen of the news`() =
        runTest {
            // Given
            val news = mock<News>()

            // Then
            viewModel.actions.test {
                assertTrue(awaitItem() is HomeViewModel.Action.None)
                viewModel.onNewsClicked(news)
                assertEquals(news, (awaitItem() as HomeViewModel.Action.NavigateToNewsScreen).news)
            }
        }

    @Test
    fun `When action is performed, we reset action state`() = runTest {
        // Given
        viewModel.onNewsClicked(mock())

        // Then
        viewModel.actions.test {
            TestCase.assertTrue(awaitItem() is HomeViewModel.Action.NavigateToNewsScreen)
            viewModel.onActionPerformed()
            TestCase.assertTrue(awaitItem() is HomeViewModel.Action.None)
        }
    }

    private fun createViewModel() {
        viewModel = HomeViewModel(repository)
    }
}
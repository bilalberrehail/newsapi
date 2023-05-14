package com.example.instantsystemtest.business.datasources

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.instantsystemtest.business.datasources.mappers.NewsRemoteMapper
import com.example.instantsystemtest.business.datasources.models.NewsApi
import com.example.instantsystemtest.business.datasources.models.NewsResponseApi
import com.example.instantsystemtest.business.models.News
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class NewsDataSourceTest {
    private val mapper: NewsRemoteMapper = mock()

    private val service: NewsService = mock()

    private lateinit var dataSource: NewsDataSource

    @Before
    fun setup() {
        dataSource = NewsDataSourceImpl(mapper, service)
    }

    @Test
    fun `When get news, result are mapped and returned`() = runTest {
        // Given
        val listNewsApi = listOf(
            NewsApi(
                title = "Titre",
                description = "Description",
                urlImage = "urlImage",
                url = "url"
            )
        )
        val listNews = listOf(
            News(
                title = "Titre",
                description = "Description",
                urlImage = "urlImage",
                url = "url"
            )
        )
        whenever(mapper.to(listNewsApi)).doReturn(listNews)
        whenever(service.getNews()).doReturn(NewsResponseApi(listNewsApi))

        // When
        val result = dataSource.getNews()

        // Then
        assertEquals(listNews, result)
    }
}
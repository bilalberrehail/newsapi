package com.example.instantsystemtest.business.repositories

import com.example.instantsystemtest.business.datasources.NewsDataSource
import com.example.instantsystemtest.business.models.News
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class NewsRepositoryTest {

    private val dataSource: NewsDataSource = mock()

    private lateinit var repository: NewsRepository

    @Before
    fun setup() {
        repository = NewsRepositoryImpl(dataSource)
    }

    @Test
    fun `When get news, result from data source is returned`() = runTest {
        // Given
        val listNews = listOf(
            News(
                title = "Titre",
                description = "Description",
                urlImage = "urlImage",
                url = "url"
            )
        )
        whenever(dataSource.getNews()).doReturn(listNews)

        // When
        val result = repository.getNews()

        // Then
        assertEquals(listNews, result)
    }
}
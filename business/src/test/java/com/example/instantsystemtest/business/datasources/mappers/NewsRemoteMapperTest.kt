package com.example.instantsystemtest.business.datasources.mappers

import com.example.instantsystemtest.business.datasources.models.NewsApi
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class NewsRemoteMapperTest {

    private lateinit var mapper: NewsRemoteMapper

    @Before
    fun setup() {
        mapper = NewsRemoteMapper()
    }

    @Test
    fun `from News API to News`() {
        // Given
        val listNewsApi = listOf(
            NewsApi(
                title = "Titre",
                description = "Description",
                urlImage = "urlImage",
                url = "url"
            )
        )

        // When
        val result = mapper.to(listNewsApi)

        // Then
        listNewsApi.zip(result).forEach {
            assertEquals(it.first.title, it.second.title)
            assertEquals(it.first.description, it.second.description)
            assertEquals(it.first.urlImage, it.second.urlImage)
            assertEquals(it.first.url, it.second.url)
        }
    }
}
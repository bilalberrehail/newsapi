package com.example.instantsystemtest.business.datasources

import com.example.instantsystemtest.business.models.News

class NewsMockDataSourceImpl : NewsDataSource {
    override suspend fun getNews(): List<News> = listOf(
        News(
            title = "Apple",
            description = "Nouvel iOS",
            urlImage = null,
            url = "https://wwww.google.fr/"
        )
    )
}
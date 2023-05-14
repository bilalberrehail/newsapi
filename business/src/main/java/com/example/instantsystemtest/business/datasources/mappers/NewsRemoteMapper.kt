package com.example.instantsystemtest.business.datasources.mappers

import com.example.instantsystemtest.business.datasources.models.NewsApi
import com.example.instantsystemtest.business.models.News

internal class NewsRemoteMapper : Mapper<List<NewsApi>, List<News>> {
    override fun to(from: List<NewsApi>) = from.map {
        News(
            title = it.title,
            description = it.description,
            urlImage = it.urlImage,
            url = it.url
        )
    }
}
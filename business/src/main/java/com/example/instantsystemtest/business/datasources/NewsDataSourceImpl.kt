package com.example.instantsystemtest.business.datasources

import com.example.instantsystemtest.business.datasources.mappers.NewsRemoteMapper
import com.example.instantsystemtest.business.models.News

internal class NewsDataSourceImpl(
    private val newsMapper: NewsRemoteMapper,
    private val service: NewsService
) : NewsDataSource {
    override suspend fun getNews(): List<News> = newsMapper.to(service.getNews().listNews)
}
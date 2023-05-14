package com.example.instantsystemtest.business.repositories

import com.example.instantsystemtest.business.datasources.NewsDataSource
import com.example.instantsystemtest.business.models.News

class NewsRepositoryImpl(private val dataSource: NewsDataSource) : NewsRepository {
    override suspend fun getNews(): List<News> = dataSource.getNews()
}
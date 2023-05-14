package com.example.instantsystemtest.business.datasources

import com.example.instantsystemtest.business.models.News

interface NewsDataSource {
    suspend fun getNews(): List<News>
}
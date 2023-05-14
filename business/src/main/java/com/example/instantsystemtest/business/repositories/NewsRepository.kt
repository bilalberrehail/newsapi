package com.example.instantsystemtest.business.repositories

import com.example.instantsystemtest.business.models.News

interface NewsRepository {
    suspend fun getNews(): List<News>
}
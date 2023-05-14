package com.example.instantsystemtest.business.datasources

import com.example.instantsystemtest.business.datasources.models.NewsResponseApi
import retrofit2.http.GET

internal interface NewsService {
    @GET("v2/everything?q=Apple")
    suspend fun getNews(): NewsResponseApi
}
package com.example.instantsystemtest.business.datasources.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class NewsResponseApi(@Json(name = "articles") val listNews: List<NewsApi>)

@JsonClass(generateAdapter = true)
internal data class NewsApi(
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "urlToImage")
    val urlImage: String?,
    @Json(name = "url")
    val url: String
)

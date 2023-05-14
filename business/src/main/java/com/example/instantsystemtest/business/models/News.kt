package com.example.instantsystemtest.business.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "urlToImage")
    val urlImage: String?,
    @Json(name = "url")
    val url: String
)
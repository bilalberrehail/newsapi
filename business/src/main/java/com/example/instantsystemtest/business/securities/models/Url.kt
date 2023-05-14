package com.example.instantsystemtest.business.securities.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class Url(
    @Json(name = "url")
    val url: String,
)

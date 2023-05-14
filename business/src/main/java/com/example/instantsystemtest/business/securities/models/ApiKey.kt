package com.example.instantsystemtest.business.securities.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ApiKey(
    @Json(name = "key")
    val key: String,
)
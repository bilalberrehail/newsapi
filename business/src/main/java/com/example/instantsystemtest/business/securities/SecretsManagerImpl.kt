package com.example.instantsystemtest.business.securities

import com.example.instantsystemtest.business.securities.models.ApiKey
import com.example.instantsystemtest.business.securities.models.ApiKeyJsonAdapter
import com.example.instantsystemtest.business.securities.models.Url
import com.example.instantsystemtest.business.securities.models.UrlJsonAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class SecretsManagerImpl : SecretsManager {

    init {
        System.loadLibrary("service-api-keys")
        System.loadLibrary("service-url")
    }

    private val moshi: Moshi by lazy { Moshi.Builder().build() }
    private val urlJsonAdapter: JsonAdapter<Url> by lazy { UrlJsonAdapter(moshi) }
    private val apiKeyJsonAdapter: JsonAdapter<ApiKey> by lazy { ApiKeyJsonAdapter(moshi) }

    private external fun getServiceUrl(): String
    private external fun getServiceApiKey(): String

    override fun serviceUrl(): String =
        urlJsonAdapter.fromJson(getServiceUrl())?.url ?: throw NullPointerException("No url found")

    override fun serviceApiKey(): String =
        apiKeyJsonAdapter.fromJson(getServiceApiKey())?.key
            ?: throw NullPointerException("No api key found")

}
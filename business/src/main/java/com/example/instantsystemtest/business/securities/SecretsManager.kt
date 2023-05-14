package com.example.instantsystemtest.business.securities

interface SecretsManager {
    fun serviceUrl(): String

    fun serviceApiKey(): String
}
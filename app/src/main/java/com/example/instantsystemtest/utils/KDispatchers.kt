package com.example.instantsystemtest.utils

import kotlinx.coroutines.CoroutineDispatcher

interface KDispatchers {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher
}
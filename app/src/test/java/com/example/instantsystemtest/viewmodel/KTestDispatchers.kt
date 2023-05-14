package com.example.instantsystemtest.viewmodel

import com.example.instantsystemtest.utils.KDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@ExperimentalCoroutinesApi
class KTestDispatchers : KDispatchers {
    override fun io(): CoroutineDispatcher = UnconfinedTestDispatcher()

    override fun main(): CoroutineDispatcher = UnconfinedTestDispatcher()
}
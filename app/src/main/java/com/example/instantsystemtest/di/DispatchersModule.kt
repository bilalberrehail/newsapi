package com.example.instantsystemtest.di

import com.example.instantsystemtest.utils.KDispatchers
import com.example.instantsystemtest.utils.KDispatchersImpl
import org.koin.dsl.module

val DISPATCHERS_MODULE = module {
    single<KDispatchers> { KDispatchersImpl() }
}
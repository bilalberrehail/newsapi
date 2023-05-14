package com.example.instantsystemtest

import android.app.Application
import com.example.instantsystemtest.business.di.API_MODULE
import com.example.instantsystemtest.di.DISPATCHERS_MODULE
import com.example.instantsystemtest.di.FEATURES_MODULE
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(API_MODULE, FEATURES_MODULE, DISPATCHERS_MODULE)
        }
    }
}
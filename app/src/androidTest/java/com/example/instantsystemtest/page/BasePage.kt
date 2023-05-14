package com.example.instantsystemtest.page

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry

open class BasePage {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    fun getString(@StringRes stringId: Int): String {
        return context.resources.getString(stringId)
    }
}
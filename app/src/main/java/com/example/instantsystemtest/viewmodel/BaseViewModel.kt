package com.example.instantsystemtest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instantsystemtest.utils.KDispatchers
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseViewModel : ViewModel(), KoinComponent {
    protected val dispatchers by inject<KDispatchers>()
}
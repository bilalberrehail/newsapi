package com.example.instantsystemtest.viewmodel

import com.example.instantsystemtest.business.models.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewsViewModel(val news: News) : BaseViewModel() {
    private val _actions = MutableStateFlow<Action>(Action.None)
    val actions: StateFlow<Action>
        get() = _actions

    fun onSeeMoreClicked() {
        _actions.value = Action.OpenUrl(url = news.url)
    }

    fun onActionPerformed() {
        _actions.value = Action.None
    }

    sealed class Action {
        object None : Action()
        data class OpenUrl(val url: String) : Action()
    }
}
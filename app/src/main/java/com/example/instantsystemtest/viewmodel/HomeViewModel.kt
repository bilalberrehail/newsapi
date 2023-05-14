package com.example.instantsystemtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.business.repositories.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val newsRepositoryImpl: NewsRepository) : BaseViewModel() {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState>
        get() = _screenState

    private val _actions = MutableStateFlow<Action>(Action.None)
    val actions: StateFlow<Action>
        get() = _actions

    private val _listNews = MutableLiveData<List<News>>(emptyList())
    val listNews: LiveData<List<News>>
        get() = _listNews

    init {
        getNews()
    }

    fun getNews() {
        viewModelScope.launch(dispatchers.main()) {
            _screenState.value = ScreenState.Loading
            try {
                val result = withContext(dispatchers.io()) {
                    newsRepositoryImpl.getNews()
                }
                _listNews.value = result

                _screenState.value = ScreenState.Success
            } catch (ex: Exception) {
                _screenState.value = ScreenState.ErrorRetrievingNews
            }
        }
    }

    fun onNewsClicked(news: News) {
        _actions.value = Action.NavigateToNewsScreen(news)
    }

    fun onActionPerformed() {
        _actions.value = Action.None
    }

    sealed class ScreenState {
        object Loading : ScreenState()
        object ErrorRetrievingNews : ScreenState()
        object Success : ScreenState()
    }

    sealed class Action {
        object None : Action()
        data class NavigateToNewsScreen(val news: News) : Action()
    }
}

package com.example.instantsystemtest.di

import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.viewmodel.HomeViewModel
import com.example.instantsystemtest.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FEATURES_MODULE = module {
    viewModel {
        HomeViewModel(newsRepositoryImpl = get())
    }

    viewModel { (news: News) ->
        NewsViewModel(news = news)
    }
}
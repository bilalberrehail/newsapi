package com.example.instantsystemtest.views.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.viewmodel.HomeViewModel
import com.example.instantsystemtest.viewmodel.NewsViewModel
import com.example.instantsystemtest.views.FullScreenCircularProgressBar
import com.example.instantsystemtest.views.news.ErrorRetrievingNewsScreen
import com.example.instantsystemtest.views.news.HomeScreen
import com.example.instantsystemtest.views.news.NewsScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

internal const val HOME_ROUTE = "home"
internal const val NEWS_ROUTE = "news-details"

private var newsDisplayed: News? = null

@ExperimentalMaterial3Api
@Composable
fun NavHostScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME_ROUTE) {
        composable(HOME_ROUTE) {
            HomeRoute(navController = navController)
        }
        composable(NEWS_ROUTE) {
            NewsRoute(news = requireNotNull(newsDisplayed) {
                "No news have been selected"
            })
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun HomeRoute(navController: NavHostController) {
    val homeViewModel: HomeViewModel = getViewModel()

    val listNews by homeViewModel.listNews.observeAsState(initial = emptyList())
    val screenState by homeViewModel.screenState.collectAsState()
    val action by homeViewModel.actions.collectAsState(initial = HomeViewModel.Action.None)

    when (screenState) {
        HomeViewModel.ScreenState.Loading -> FullScreenCircularProgressBar()
        HomeViewModel.ScreenState.ErrorRetrievingNews -> ErrorRetrievingNewsScreen(onRetryClicked = homeViewModel::getNews)
        HomeViewModel.ScreenState.Success -> HomeScreen(
            listNews = listNews,
            onNewsClicked = homeViewModel::onNewsClicked
        )
    }

    when (action) {
        HomeViewModel.Action.None -> {
            // Nothing to do
        }

        is HomeViewModel.Action.NavigateToNewsScreen -> {
            newsDisplayed = (action as HomeViewModel.Action.NavigateToNewsScreen).news
            navController.navigate(
                route = NEWS_ROUTE,
                navOptions = null,
                navigatorExtras = null
            )
            homeViewModel.onActionPerformed()
        }
    }
}

@Composable
fun NewsRoute(news: News) {
    val newsViewModel: NewsViewModel = getViewModel {
        parametersOf(news)
    }
    val action by newsViewModel.actions.collectAsState(initial = NewsViewModel.Action.None)

    NewsScreen(news = newsViewModel.news, onSeeMoreClicked = newsViewModel::onSeeMoreClicked)

    when (action) {
        NewsViewModel.Action.None -> {
            // Nothing to do
        }

        is NewsViewModel.Action.OpenUrl -> {
            val uriHandler = LocalUriHandler.current
            uriHandler.openUri((action as NewsViewModel.Action.OpenUrl).url)
            newsViewModel.onActionPerformed()
        }
    }
}
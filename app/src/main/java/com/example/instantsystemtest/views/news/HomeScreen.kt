package com.example.instantsystemtest.views.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instantsystemtest.R
import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.ui.theme.typography

enum class HomeTag {
    LIST_NEWS
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(listNews: List<News>, onNewsClicked: (News) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(text = stringResource(id = R.string.home_page_subtitle), style = typography.title)

        LazyColumn(
            modifier = Modifier
                .padding(top = 8.dp)
                .testTag(HomeTag.LIST_NEWS.name),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listNews) {
                NewsCardComponent(news = it, onClick = {
                    onNewsClicked(it)
                })
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(listNews = listOf(
            News(
                title = "New version of iOS",
                description = "First developer beta bringing many changes as described in the article and seen in the video below (public beta released on March 30)",
                urlImage = "https://play-lh.googleusercontent.com/7oYf_DNF77eJr9bIoY_GuN1OmYbgQL2VkZLTUfVI4TAspf8qdSjeJpIYbNQe-Va3FJlk",
                url = "https://www.iphon.fr/post/ios-16-5-ipados-quelles-nouveautes"
            ), News(
                title = "Apple Arcade launches 20 new games, including a new TMNT roguelike",
                description = "Apple Arcade is getting 20 new games, and that includes the exclusive launch of the TMNT Splintered Fate, a co-op roguelike.",
                urlImage = "https://play-lh.googleusercontent.com/7oYf_DNF77eJr9bIoY_GuN1OmYbgQL2VkZLTUfVI4TAspf8qdSjeJpIYbNQe-Va3FJlk",
                url = "https://www.iphon.fr/post/ios-16-5-ipados-quelles-nouveautes"
            )
        ), onNewsClicked = {})
    }
}
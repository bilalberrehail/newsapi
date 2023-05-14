package com.example.instantsystemtest.views.news

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.instantsystemtest.R
import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.ui.theme.palette
import com.example.instantsystemtest.ui.theme.typography

enum class NewsCardTag {
    TITLE
}

@ExperimentalMaterial3Api
@Composable
fun NewsCardComponent(news: News, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = palette.grey100,
        ),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = rememberAsyncImagePainter(
                    model = news.urlImage,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.placeholder)
                ),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(96.dp),
            )
            Text(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .testTag(NewsCardTag.TITLE.name),
                text = news.title,
                style = typography.title
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun NewsCardComponentPreview() {
    MaterialTheme {
        NewsCardComponent(
            news = News(
                title = "New version of iOS",
                description = "First developer beta bringing many changes as described in the article and seen in the video below (public beta released on March 30)",
                urlImage = "https://play-lh.googleusercontent.com/7oYf_DNF77eJr9bIoY_GuN1OmYbgQL2VkZLTUfVI4TAspf8qdSjeJpIYbNQe-Va3FJlk",
                url = "https://www.iphon.fr/post/ios-16-5-ipados-quelles-nouveautes"
            ),
            onClick = {}
        )
    }
}
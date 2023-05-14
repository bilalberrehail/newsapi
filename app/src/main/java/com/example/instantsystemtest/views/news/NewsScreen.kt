package com.example.instantsystemtest.views.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.instantsystemtest.R
import com.example.instantsystemtest.business.models.News
import com.example.instantsystemtest.ui.theme.palette
import com.example.instantsystemtest.ui.theme.typography

@Composable
fun NewsScreen(news: News, onSeeMoreClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = news.title, style = typography.title)

        Icon(
            modifier = Modifier
                .size(128.dp)
                .padding(top = 12.dp),
            painter = rememberAsyncImagePainter(
                model = news.urlImage,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            ),
            tint = Color.Unspecified,
            contentDescription = null,
        )

        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = news.description,
            style = typography.description,
            textAlign = TextAlign.Justify
        )

        Button(
            modifier = Modifier.padding(top = 18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = palette.blue100),
            contentPadding = PaddingValues(horizontal = 20.dp),
            onClick = onSeeMoreClicked
        ) {
            Text(
                text = stringResource(id = R.string.option_see_more),
                style = typography.normal,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
private fun NewsScreenPreview() {
    MaterialTheme {
        NewsScreen(
            news = News(
                title = "New version of iOS",
                description = "First developer beta bringing many changes as described in the article and seen in the video below (public beta released on March 30)",
                urlImage = "https://play-lh.googleusercontent.com/7oYf_DNF77eJr9bIoY_GuN1OmYbgQL2VkZLTUfVI4TAspf8qdSjeJpIYbNQe-Va3FJlk",
                url = "https://www.iphon.fr/post/ios-16-5-ipados-quelles-nouveautes"
            ),
            onSeeMoreClicked = {}
        )
    }
}
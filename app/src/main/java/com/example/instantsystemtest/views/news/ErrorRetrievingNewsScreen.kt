package com.example.instantsystemtest.views.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.instantsystemtest.R
import com.example.instantsystemtest.ui.theme.palette
import com.example.instantsystemtest.ui.theme.typography

@Composable
fun ErrorRetrievingNewsScreen(onRetryClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.error_retrieving_news), style = typography.title)

        Button(
            modifier = Modifier.padding(top = 18.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = palette.blue100),
            contentPadding = PaddingValues(horizontal = 20.dp),
            onClick = onRetryClicked
        ) {
            Text(
                text = stringResource(id = R.string.retry),
                style = typography.normal,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}
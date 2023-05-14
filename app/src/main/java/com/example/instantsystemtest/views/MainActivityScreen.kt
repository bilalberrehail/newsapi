package com.example.instantsystemtest.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.instantsystemtest.R
import com.example.instantsystemtest.ui.theme.typography

@ExperimentalMaterial3Api
@Composable
fun MainActivityScreen(
    navController: NavHostController,
    canPop: Boolean,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    if (canPop) {
                        IconButton(
                            onClick = { navController.navigateUp() }
                        ) { Icon(Icons.Default.ArrowBack, "Back") }
                    }
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.home_page_title),
                        style = typography.title
                    )
                }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                content()
            }
        }
    )
}

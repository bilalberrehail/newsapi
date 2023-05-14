package com.example.instantsystemtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instantsystemtest.views.MainActivityScreen
import com.example.instantsystemtest.views.navigation.HOME_ROUTE
import com.example.instantsystemtest.views.navigation.NavHostScreen

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            MaterialTheme {
                MainActivityScreen(
                    navController = navController,
                    canPop = navBackStackEntry?.destination?.route != null && navBackStackEntry?.destination?.route != HOME_ROUTE
                ) {
                    NavHostScreen(navController = navController)
                }
            }
        }
    }

}
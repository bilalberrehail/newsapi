package com.example.instantsystemtest.page

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import com.example.instantsystemtest.R

class NewsPage(private val composeTestRule: ComposeContentTestRule) : BasePage() {
    fun checkContent() {
        composeTestRule.onNodeWithText("Apple").assertIsDisplayed()
        composeTestRule.onNodeWithText("Nouvel iOS").assertIsDisplayed()
        composeTestRule.onNodeWithText(getString(R.string.option_see_more)).assertIsDisplayed()
    }
}
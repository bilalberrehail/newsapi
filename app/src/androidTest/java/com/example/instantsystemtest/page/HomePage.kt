package com.example.instantsystemtest.page

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.instantsystemtest.R
import com.example.instantsystemtest.views.news.HomeTag
import com.example.instantsystemtest.views.news.NewsCardTag

class HomePage(private val composeTestRule: ComposeContentTestRule) : BasePage() {
    fun assertContent() {
        composeTestRule.onNodeWithText(getString(R.string.home_page_subtitle)).assertIsDisplayed()
        composeTestRule.onNodeWithTag(HomeTag.LIST_NEWS.name).onChildren().assertCountEquals(1)
        composeTestRule.onNodeWithTag(HomeTag.LIST_NEWS.name).onChildren()

        composeTestRule.onAllNodesWithTag(NewsCardTag.TITLE.name, true)[0].assertTextEquals("Apple")
    }

    fun clickOnNewsCard(index: Int) {
        composeTestRule.onNodeWithTag(HomeTag.LIST_NEWS.name).onChildren()[index].performClick()
    }
}
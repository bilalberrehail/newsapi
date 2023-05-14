package com.example.instantsystemtest.test

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.instantsystemtest.MainActivity
import com.example.instantsystemtest.business.datasources.NewsDataSource
import com.example.instantsystemtest.business.datasources.NewsMockDataSourceImpl
import com.example.instantsystemtest.page.HomePage
import com.example.instantsystemtest.page.NewsPage
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest

@ExperimentalMaterial3Api
@RunWith(AndroidJUnit4::class)
class MainTest : KoinTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockModule = module {
        single<NewsDataSource> {
            NewsMockDataSourceImpl()
        }
    }

    private val homePage = HomePage(composeTestRule)
    private val newsPage = NewsPage(composeTestRule)

    @Before
    fun setup() {
        loadKoinModules(mockModule)
    }

    @After
    fun setDown() {
        unloadKoinModules(mockModule)
    }

    @Test
    fun go_to_news_screen_and_check_content() {
        homePage.assertContent()
        homePage.clickOnNewsCard(0)
        newsPage.checkContent()
    }
}
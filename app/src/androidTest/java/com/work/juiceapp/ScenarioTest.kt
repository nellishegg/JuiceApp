package com.work.juiceapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ScenarioTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    fun caseNumberOne() {
        val appPage = AppPage()

        appPage.checkStateIsInitial()

        appPage.clickNextButton()
        repeat(5) {

            appPage.checkSqueezeState()
            appPage.clickImage()
        }

        appPage.checkStateIsProcess()//2/1 continue
        appPage.clickNextButton()

        appPage.checkStateIsMadeState()
        appPage.clickNextButton()

        appPage.checkFinishState()

        appPage.clickRestartButton()
        appPage.checkStateIsInitial()


    }
}
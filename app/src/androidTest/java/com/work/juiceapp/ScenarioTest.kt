package com.work.juiceapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun caseNumberOne() {
        val appPage = AppPage()

        appPage.checkInitialState() //1

        appPage.clickNextButton()

        repeat(5) {
            appPage.checkSqueezeState()//2
            appPage.clickImage()
        }

        appPage.checkProcessState()//2.1

        appPage.clickNextButton()

        appPage.checkMadeState() //3
        appPage.clickNextButton()

        appPage.checkFinishState()//4

        appPage.clickRestartButton()
        appPage.checkInitialState()//1


    }
}
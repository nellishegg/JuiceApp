package com.work.juiceapp

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class TitleUi(
    private val parent: Matcher<View>,
    private val rootId: Int,
//    private val clickTimes: String,
) {

    //1-изменяемость текста при каждом новом состоянии(4)
    // 2- изменяемость цифры в тексте в состоянии 2 и 2.1

    private val text: Int = R.id.titleTextViewId

    // TODO: download pics
//    private val firstStateTitle =
//    private val secondStateTitle =
//    private val thirdStateTitle =
//    private val fourthStateTitle =


    private val interaction = onView(
        Matchers.allOf(
            withId(text),
            withText("Please tap to select a lemon"),
            isAssignableFrom(TextView::class.java),
            parent,
            withParent(withId(rootId)),
        )
    ).check(matches(isDisplayed()))

    fun checkInitialState() {
       interaction
    }

    fun checkSqueezeState(text: Int) {
        TODO("Not yet implemented")
    }

    fun checkProcessState() {
        TODO("Not yet implemented")
    }

    fun checkMadeState() {
        TODO("Not yet implemented")
    }

    fun checkFinishState() {
        TODO("Not yet implemented")


    }

    fun decrementClickTimes() {

    }

}

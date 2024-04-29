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
) {

    //1-изменяемость текста при каждом новом состоянии(4)
    // 2- изменяемость цифры в тексте в состоянии 2 и 2.1

    private val text: Int = R.id.titleTextView


    private val initialStateTitle = "Tap the button to select a lemon"
    private val squeezeStateTitle = "Keep tapping the lemon to squeeze it"
    private val madeStateTitle = "Tap the button to drink the lemonade"
    private val finishStateTitle = "Tap the button to start again"


    private val interaction = onView(
        Matchers.allOf(
            withId(text),
            isAssignableFrom(TextView::class.java),
            parent,
            withParent(withId(rootId)),
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isDisplayed()))
            .check(matches(withText(initialStateTitle)))
    }

    fun checkSqueezeState() {
        // TODO: check num state
        interaction.check(matches(withText(squeezeStateTitle)))
    }

    fun checkProcessState() {
        // TODO: check num state
        interaction.check(matches(withText(squeezeStateTitle)))
    }

    fun checkMadeState() {
        interaction.check(matches(withText(madeStateTitle)))
    }

    fun checkFinishState() {
        interaction.check(matches(withText(finishStateTitle)))

    }


}

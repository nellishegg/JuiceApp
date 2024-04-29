package com.work.juiceapp

import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not


class ButtonUi(
    private val parent: Matcher<View>,
    private val rootId: Int,
) {

    private val button: Int = R.id.mainButton

    private val interaction = Espresso.onView(
        Matchers.allOf(
            withId(button),
            isAssignableFrom(Button::class.java),
            parent,
            ViewMatchers.withParent(withId(rootId)),
        )
    )

    fun click() {
        interaction.perform(ViewActions.click())
    }

    fun checkInitialState() {
        interaction.check(matches(isEnabled()))
            .check(matches(withText(R.string.next)))
    }


    fun checkSqueezeState() {
        interaction.check(matches(not(isEnabled())))
            .check(matches(withText(R.string.next)))
        
    }

    fun checkProcessState() {
        interaction.check(matches(isEnabled()))
            .check(matches(withText(R.string.next)))
        
    }

    fun checkMadeState() {
        interaction.check(matches(isEnabled()))
            .check(matches(withText(R.string.next)))


    }

    fun checkFinishState() {
        interaction.check(matches(isEnabled()))
            .check(matches(withText(R.string.restart)))

    }


}

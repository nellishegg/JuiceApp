package com.work.juiceapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not

class ImageUi(
    parent: Matcher<View>,
    rootId: Int,
) {
    private val image:Int = R.id.imageViewId

    private val treeImage = R.drawable.tree
    private val lemonImage = R.drawable.lemon
    private val lemonadeImage = R.drawable.lemonade
    private val glassImage = R.drawable.glass

    private val interaction = Espresso.onView(
        Matchers.allOf(
            withId(image),
            ViewMatchers.isAssignableFrom(ImageView::class.java),
            parent,
            ViewMatchers.withParent(withId(rootId)),
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isDisplayed()))
            .check(matches(not(isClickable())))
            .check(matches(CheckImageMatcher(treeImage)))
    }


    fun checkSqueezeState() {
        interaction.check(matches(isClickable()))
            .check(matches(CheckImageMatcher(lemonImage)))

    }

    fun checkProcessState() {
        interaction.check(matches(not(isClickable())))
            .check(matches(CheckImageMatcher(lemonImage)))
    }

    fun checkMadeState() {
        interaction.check(matches(not(isClickable())))
            .check(matches(CheckImageMatcher(lemonadeImage)))
    }

    fun checkFinishState() {
        interaction.check(matches(not(isClickable())))
            .check(matches(CheckImageMatcher(glassImage)))
    }

    fun click() {
        interaction.perform(ViewActions.click())
    }

}





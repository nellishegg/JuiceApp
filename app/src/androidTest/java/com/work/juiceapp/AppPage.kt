package com.work.juiceapp

import android.icu.text.CaseMap.Title
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

class AppPage() {

    private val parent = withParent(isAssignableFrom(LinearLayout::class.java))
    private val rootId: Int = R.id.rootLayout

    private val imageUi = ImageUi()
    private val buttonUI = ButtonUi()
    private val titleUi = TitleUi(parent,rootId)

//    private val button: Int = R.id.buttonImageId
//    private val text: Int = R.id.titleTextViewId
//    private val image:Int = R.id.imageViewId

    fun checkInitialState() {
        titleUi.checkInitialState()
        buttonUI.checkInitialState()
        imageUi.checkInitialState()

        onView(
            allOf(
                withId(image),
                isAssignableFrom(TextView::class.java),
                parent,
                withParent(withId(rootId)),
            )
        ).check(matches(isDisplayed()))
            .check(matches(not(isClickable())))


        onView(
            allOf(
                withId(button),
                withText("Next"),
                parent,
                parent,
                withParent(withId(rootId)),
            )
        ).check(matches(isDisplayed()))
            .check(matches(isClickable()))

    }

    fun clickNextButton() {
        onView(withId(button)).perform(click())
    }

    fun clickImage() {
        onView(withId(image)).perform(click())

    }

    fun clickRestartButton() {
        onView(withId(button)).perform(click())
    }

    fun checkSqueezeState(text: Int) {//нужны ли параметры
        titleUi.checkSqueezeState(text)//text
        imageUi.checkActive()
        buttonUI.checkInactive()


//        checkImage
//        checkText.contains(text)
//        checkButtonIsDisabled
    }

    fun checkProcessState() {
        titleUi.checkProcessState()
        imageUi.checkInactive()
        buttonUI.checkActive()
//        checkImageAnother
//        checkText
//        checkButtonIsEnabled
    }

    fun checkMadeState() {
        titleUi.checkMadeState()
        imageUi.checkInactive()
        buttonUI.checkActive()
    }

    fun checkFinishState() {
        titleUi.checkFinishState()
        imageUi.checkInactive()
        buttonUI.checkActive()
    }


}

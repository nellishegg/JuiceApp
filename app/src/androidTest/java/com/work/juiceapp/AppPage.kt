package com.work.juiceapp

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withParent

class AppPage() {

    private val parent = withParent(isAssignableFrom(LinearLayout::class.java))
    private val rootId: Int = R.id.rootLayout

    private val imageUi = ImageUi(parent, rootId)
    private val buttonUi = ButtonUi(parent, rootId)
    private val titleUi = TitleUi(parent, rootId)


    fun checkInitialState() {
        titleUi.checkInitialState()
        imageUi.checkInitialState()
        buttonUi.checkInitialState()

    }

    fun clickNextButton() {
        buttonUi.click()
    }
    fun clickImage() {
        imageUi.click()
    }
    fun clickRestartButton() {
        buttonUi.click()
    }
    fun checkSqueezeState() {
        titleUi.checkSqueezeState()//text
        imageUi.checkSqueezeState()
        buttonUi.checkSqueezeState()

    }
    fun checkProcessState() {
        titleUi.checkProcessState()
        imageUi.checkProcessState()
        buttonUi.checkProcessState()

    }
    fun checkMadeState() {
        titleUi.checkMadeState()
        imageUi.checkMadeState()
        buttonUi.checkMadeState()
    }
    fun checkFinishState() {
        titleUi.checkFinishState()
        imageUi.checkFinishState()
        buttonUi.checkFinishState()
    }


}

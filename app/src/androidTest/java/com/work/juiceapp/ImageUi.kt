package com.work.juiceapp

import android.view.View
import org.hamcrest.Matcher
import org.junit.runners.ParentRunner

class ImageUi(
    private val rootId: Int,
    private val parent: Matcher<View>,
    private val image:Int
    ) {


}

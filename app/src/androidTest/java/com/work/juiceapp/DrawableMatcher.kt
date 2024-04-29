package com.work.juiceapp

import android.graphics.drawable.VectorDrawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class DrawableMatcher(@DrawableRes private val drawableResId: Int) :
    BoundedMatcher<View , ImageView>(ImageView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("with drawable from resource id: ")
        description.appendValue(drawableResId)
    }

    override fun matchesSafely(target: ImageView?): Boolean {
        if (target !is ImageView) {
            return false
        }
        if (drawableResId < 0) {
            return target.drawable == null
        }

        val expectedDrawable = ContextCompat.getDrawable(target.context, drawableResId)
            ?: return false

        val bitmap = (target.drawable as VectorDrawable).toBitmap()
        val otherBitmap = (expectedDrawable as VectorDrawable).toBitmap()
        return bitmap.sameAs(otherBitmap)
    }
}

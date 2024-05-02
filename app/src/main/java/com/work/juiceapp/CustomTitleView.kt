package com.work.juiceapp

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes

class CustomTitleView : androidx.appcompat.widget.AppCompatTextView, UpdateCustomTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun update(resId: Int) {
        setText(resId)
    }
}

interface UpdateCustomTextView {
    fun update(@StringRes resId: Int)
}


package com.work.juiceapp

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.view.isGone

class CustomImageButton : androidx.appcompat.widget.AppCompatImageButton, UpdateCustomImageButton {

    private lateinit var uiState: ImageUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: ImageUiState) {
        uiState = outer
        uiState.update(this)
    }

    override fun updateUi(resId: Int, clickable: Boolean) {
        this.setImageResource(resId)
        this.isClickable = clickable
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ImageSaveState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ImageSaveState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateCustomImageButton {
    fun updateUiState(outer: ImageUiState)
    fun updateUi(@DrawableRes resId: Int, clickable: Boolean)
}


package com.work.juiceapp

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.ImageButton

import androidx.appcompat.widget.AppCompatButton

class CustomImageButton : androidx.appcompat.widget.AppCompatImageButton {

    private lateinit var uiState: ImageUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    fun updateUiState(outer: ImageUiState) {
        uiState = outer
        uiState.update(this)
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


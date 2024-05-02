package com.work.juiceapp

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatButton

class CustomActionButton : AppCompatButton, UpdateCustomActionButton {


    private lateinit var uiState: ButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: ButtonUiState) {
        uiState = outer
        uiState.update(this)
    }

    override fun updateUi(resId: Int, enabled: Boolean) {
        setText(resId)
        this.isEnabled = enabled
        this.setBackgroundColor(
            if (enabled) resources.getColor(R.color.yellow) else resources.getColor(R.color.gray)
        )
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ActionSaveState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ActionSaveState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }

    fun handleAction(gameViewModel: Actions): UiState {
        return uiState.handleAction(gameViewModel)
    }
}

interface UpdateCustomActionButton {

    fun updateUiState(outer: ButtonUiState)
    fun updateUi(@StringRes resId: Int, enabled: Boolean)
}
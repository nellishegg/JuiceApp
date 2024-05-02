package com.work.juiceapp

import androidx.annotation.StringRes

interface TitleUiState {
    fun update(titleTextView: UpdateCustomTextView)

    abstract class Abstract(@StringRes private val resId: Int) : TitleUiState {
        override fun update(titleTextView: UpdateCustomTextView) {
            titleTextView.update(resId)
        }
    }

    object Initial : Abstract(R.string.tree)

    object Squeeze : Abstract(R.string.squeeze)

    object Process : Abstract(R.string.squeeze)

    object Made : Abstract(R.string.made)

    object Finish : Abstract(R.string.finish)

}




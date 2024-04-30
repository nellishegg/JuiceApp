package com.work.juiceapp

import android.widget.TextView
import androidx.annotation.StringRes

interface TitleUiState {
    fun update(titleTextView: TextView)

    abstract class Abstract(@StringRes private val resId: Int) : TitleUiState {
        override fun update(titleTextView: TextView) {
            titleTextView.setText(resId)
        }
    }

    object Initial : Abstract(R.string.tree)

    object Squeeze : Abstract(R.string.squeeze)

    object Process : Abstract(R.string.squeeze)

    object Made : Abstract(R.string.made)

    object Finish : Abstract(R.string.finish)

}

package com.work.juiceapp

import androidx.annotation.DrawableRes
import java.io.Serializable

interface ImageUiState : Serializable {

    fun update(imageButton:UpdateCustomImageButton)

    abstract class Abstract(
        @DrawableRes private val resId: Int,
        private val isClickable: Boolean = false
    ) : ImageUiState {
        override fun update(imageButton: UpdateCustomImageButton) {
            imageButton.updateUi(resId,isClickable)

        }
    }

    object Initial : Abstract(R.drawable.tree)

    object Squeeze : Abstract(R.drawable.lemon, true)

    object Process : Abstract(R.drawable.lemon)

    object Made : Abstract(R.drawable.lemonade)

    object Finish : Abstract(R.drawable.glass)
}

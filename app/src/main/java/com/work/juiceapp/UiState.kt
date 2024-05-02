package com.work.juiceapp

import java.io.Serializable

interface UiState : Serializable {

    fun update(
        titleCustom: UpdateCustomTextView,
        actionButton: UpdateCustomActionButton,
        imageButton: UpdateCustomImageButton,
    )

    object Empty : UiState {
        override fun update(
            titleCustom: UpdateCustomTextView,
            actionButton: UpdateCustomActionButton,
            imageButton: UpdateCustomImageButton,
        ) = Unit
    }

    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : UiState {
        override fun update(
            titleCustom: UpdateCustomTextView,
            actionButton: UpdateCustomActionButton,
            imageButton: UpdateCustomImageButton,
        ) {
            title.update(titleCustom)
            imageButton.updateUiState(image)
            actionButton.updateUiState(button)
        }
    }

    data class Initial(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button)

    data class Squeeze(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button)

    data class Process(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button)

    data class Made(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button)

    data class Finish(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button)
}


package com.work.juiceapp

import com.work.juiceapp.databinding.ActivityMainBinding
import java.io.Serializable
import java.lang.IllegalStateException

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)

    // Abstract class - общий код для всех классов, которые реализуют интерфейс
    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : UiState {
        override fun update(binding: ActivityMainBinding) = with(binding) {
            title.update(titleTextView)
            imageButton.updateUiState(image)
            mainButton.updateUiState(button)
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


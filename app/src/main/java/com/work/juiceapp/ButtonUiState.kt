package com.work.juiceapp

import android.widget.Button
import androidx.annotation.StringRes
import java.io.Serializable
import java.lang.IllegalStateException

interface ButtonUiState : Serializable {
    fun update(mainButton: Button)
    fun handleAction(gameViewModel: Actions): UiState


    abstract class Abstract(
        @StringRes private val resId: Int = R.string.next,
        private val enabled: Boolean = true
    ) : ButtonUiState {
        override fun update(mainButton: Button) {
            mainButton.setText(resId)
            mainButton.isEnabled = enabled
        }
    }

    object Initial : Abstract() {
        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.goToSqueeze()
        }
    }

    object Squeeze : Abstract(enabled = false) {
        override fun handleAction(gameViewModel: Actions): UiState {
            throw IllegalStateException()
        }
    }

    object Process : Abstract() {
        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.goToMade()
        }
    }

    object Made : Abstract() {
        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.goToFinish()
        }
    }

    object Finish : Abstract(resId = R.string.restart) {
        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.startAgain()
        }
    }
}

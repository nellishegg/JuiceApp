package com.work.juiceapp

import androidx.annotation.StringRes
import java.io.Serializable

interface ButtonUiState : Serializable {

    fun update(mainButton: UpdateCustomActionButton)
    fun handleAction(gameViewModel: Actions): UiState


    abstract class Abstract(
        @StringRes private val resId: Int = R.string.next,
        private val enabled: Boolean = true
    ) : ButtonUiState {
        override fun update(mainButton: UpdateCustomActionButton) {
            mainButton.updateUi(resId, enabled)
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

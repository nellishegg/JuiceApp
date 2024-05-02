package com.work.juiceapp

class GameViewModel(
    private val repository: Repository // Repository.Base()
) : Actions {

    fun init(isFirstTime: Boolean = true): UiState {
        repository.reset()
        return if (isFirstTime) {
            UiState.Initial(
                title = TitleUiState.Initial,
                image = ImageUiState.Initial,
                button = ButtonUiState.Initial,
            )
        } else UiState.Empty
    }

    override fun goToSqueeze(): UiState = UiState.Squeeze(
        title = TitleUiState.Squeeze,
        image = ImageUiState.Squeeze,
        button = ButtonUiState.Squeeze,
    )

    fun handleImage(): UiState {
        repository.increment()
        return if (repository.isMax()) {
            UiState.Process(
                title = TitleUiState.Process,
                image = ImageUiState.Process,
                button = ButtonUiState.Process,
            )
        } else {
            UiState.Squeeze(
                title = TitleUiState.Squeeze,
                image = ImageUiState.Squeeze,
                button = ButtonUiState.Squeeze
            )
        }
    }


    override fun goToMade(): UiState = UiState.Made(
        title = TitleUiState.Made,
        image = ImageUiState.Made,
        button = ButtonUiState.Made,
    )


    override fun goToFinish(): UiState = UiState.Finish(
        title = TitleUiState.Finish,
        image = ImageUiState.Finish,
        button = ButtonUiState.Finish,
    )

    override fun startAgain(): UiState {
        repository.reset()
        return init()
    }
}

interface Actions {
    fun goToSqueeze(): UiState
    fun goToMade(): UiState
    fun goToFinish(): UiState
    fun startAgain(): UiState
}
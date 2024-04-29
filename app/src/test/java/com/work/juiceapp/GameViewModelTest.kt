package com.work.juiceapp

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel
    private lateinit var repository: FakeRepository

    @Before
    fun setUp() {
        repository = FakeRepository()
        viewModel = GameViewModel(
            repository = repository
        )
    }

    @Test
    fun caseNumberOne() {

        var actual: UiState = viewModel.init()
        var expected: UiState = UiState.Initial(
            title = TitleUiState.Initial,
            image = ImageUiState.Initial,
            button = ButtonUiState.Initial,
        )
        assertEquals(expected, actual)


        actual = viewModel.goToSqueeze()//обработка нажатия кнопки next
        expected = UiState.Squeeze(
            title = TitleUiState.Squeeze,
            image = ImageUiState.Squeeze,
            button = ButtonUiState.Squeeze,

            )
        assertEquals(expected, actual)


        repeat(5) {
            assertEquals(expected, actual)
            actual = viewModel.handleImage()

        }

        expected = UiState.Process(
            title = TitleUiState.Process,
            image = ImageUiState.Process,
            button = ButtonUiState.Process,
        )
        assertEquals(expected, actual)


        actual = viewModel.goToMade()
        expected = UiState.Made(
            title = TitleUiState.Made,
            image = ImageUiState.Made,
            button = ButtonUiState.Made,
        )
        assertEquals(expected, actual)


        actual = viewModel.goToFinish()
        expected = UiState.Finish(
            title = TitleUiState.Finish,
            image = ImageUiState.Finish,
            button = ButtonUiState.Finish,
        )
        assertEquals(expected, actual)


        actual = viewModel.startAgain()
        expected = UiState.Initial(
            title = TitleUiState.Initial,
            image = ImageUiState.Initial,
            button = ButtonUiState.Initial,
        )
        assertEquals(expected, actual)

    }
}

private class FakeRepository() : Repository {

    private var currentTimesClicked = 0

    override fun increment() {
        currentTimesClicked++
    }

    override fun isMax(): Boolean {
        return currentTimesClicked == 5
    }

    override fun reset() {
        currentTimesClicked = 0
    }
}
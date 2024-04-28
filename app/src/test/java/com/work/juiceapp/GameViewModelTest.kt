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
        viewModel = MainViewModel(
            repository = repository
        )
    }

    @Test
    fun caseNumberOne() {

        var actual = viewModel.init()
        var expected = UiState.InitialState(
            title = TitleUi.InitialState(value = "text1"),
            image = ImageUi.InitialState,
            button = ButtonUi.InitialState(value = "button text 1"),
        )
        assertEquals(expected, actual)


        actual = viewModel.handleButton()//обработка нажатия кнопки next
        expected = UiState.SqueezeState(
            title = TitleUi.SqueezeState(value = "text2"),
            image = ImageUi.SqueezeState(),
            button = ButtonUi.SqueezeState(value = "button text 1"),

            )
        assertEquals(expected, actual)


        repeat(5) {
            actual = viewModel.handleImage()
            expected = UiState.SqueezeState(
                title = TitleUi.SqueezeState(value = "text2"),
                image = ImageUi.SqueezeState(),
                button = ButtonUi.SqueezeState(value = "button text 1")
            )
            assertEquals(expected, actual)
        }

        actual = viewModel.handleButton()
        expected = UiState.ProcessState(
            title = TitleUi.ProcessState(value = "text2"),
            image = ImageUi.ProcessState(),
            button = ButtonUi.ProcessState(value = "button text 1"),
        )
        assertEquals(expected, actual)


        actual = viewModel.handleButton()
        expected = UiState.MadeState(
            title = TitleUi.MadeState(value = "text3"),
            image = ImageUi.MadeState(),
            button = ButtonUi.MadeState(value = "button text 1"),
        )
        assertEquals(expected, actual)


        actual = viewModel.handleButton()
        expected = UiState.FinishState(
            title = TitleUi.FinishState(value = "text4"),
            image = ImageUi.FinishState(),
            button = ButtonUi.FinishState(value = "button text 2"),
        )
        assertEquals(expected, actual)


        actual = viewModel.handleButton()
        expected = UiState.InitialState(
            title = TitleUi.InitialState(value = "text1"),
            image = ImageUi.InitialState(),
            button = ButtonUi.InitialState(value = "button text 1"),
        )
        assertEquals(expected, actual)

    }
}

private class FakeRepository(number: Int) : Repository {

    private var currentTimesNumber = 5
    private var currentIndex = 0

    fun decrement() {
        while (currentIndex > 5) {
            currentTimesNumber--
            currentIndex++
        }
    }


}
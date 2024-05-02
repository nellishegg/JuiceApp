package com.work.juiceapp

import org.junit.Test

class UiStateTest() {
    @Test
    fun test() {
        val initial =
            UiState.Initial(TitleUiState.Initial, ImageUiState.Initial, ButtonUiState.Initial)
        initial.update(FakeTitleView(), FakeButtonView(), FakeImageView())
    }
}

private class FakeTitleView() : UpdateCustomTextView {
    override fun update(resId: Int) {
    }
}

private class FakeImageView() : UpdateCustomImageButton {
    override fun updateUiState(outer: ImageUiState) {
    }

    override fun updateUi(resId: Int, clickable: Boolean) {

    }
}

private class FakeButtonView() : UpdateCustomActionButton {
    override fun updateUiState(outer: ButtonUiState) {
    }

    override fun updateUi(resId: Int, enabled: Boolean) {
    }
}
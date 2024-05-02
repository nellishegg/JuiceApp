package com.work.juiceapp

import org.junit.Assert.assertEquals
import org.junit.Test

class ButtonUiStateTest {
    @Test
    fun testInit() {
        val value = ButtonUiState.Initial
        val button = FakeActionButton()
        value.update(button)
        assertEquals(R.string.next, button.actualId)
        assertEquals(true, button.actualVisibility)
    }
    @Test
    fun testSqueeze() {
        val value = ButtonUiState.Squeeze
        val button = FakeActionButton()
        value.update(button)
        assertEquals(R.string.next, button.actualId)
        assertEquals(false, button.actualVisibility)
    }
    @Test
    fun testSProcess() {
        val value = ButtonUiState.Process
        val button = FakeActionButton()
        value.update(button)
        assertEquals(R.string.next, button.actualId)
        assertEquals(true, button.actualVisibility)
    }
    @Test
    fun testMade() {
        val value = ButtonUiState.Made
        val button = FakeActionButton()
        value.update(button)
        assertEquals(R.string.next, button.actualId)
        assertEquals(true, button.actualVisibility)
    }
    @Test
    fun testFinish() {
        val value = ButtonUiState.Finish
        val button = FakeActionButton()
        value.update(button)
        assertEquals(R.string.restart, button.actualId)
        assertEquals(true, button.actualVisibility)
    }
}

private class FakeActionButton() : UpdateCustomActionButton {

    override fun updateUiState(outer: ButtonUiState) {
    }

    var actualId = 0
    var actualVisibility = true
    override fun updateUi(resId: Int, enabled: Boolean) {
        actualId = resId
        actualVisibility = enabled
    }
}
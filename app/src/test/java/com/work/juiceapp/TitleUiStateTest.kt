package com.work.juiceapp

import org.junit.Assert.*
import org.junit.Test

class TitleUiStateTest {
    @Test
    fun testInitial() {
        val value = TitleUiState.Initial
        val text =FakeText()
        value.update(text)
        assertEquals(R.string.tree, text.actualText)
    }

    @Test
    fun testSqueeze() {
        val value = TitleUiState.Squeeze
        val text =FakeText()
        value.update(text)
        assertEquals(R.string.squeeze, text.actualText)
    }

    @Test
    fun testProcess() {
        val value = TitleUiState.Process
        val text =FakeText()
        value.update(text)
        assertEquals(R.string.squeeze, text.actualText)
    }

    @Test
    fun testMade() {
        val value = TitleUiState.Made
        val text =FakeText()
        value.update(text)
        assertEquals(R.string.made, text.actualText)
    }

    @Test
    fun testFinish() {
        val value = TitleUiState.Finish
        val text =FakeText()
        value.update(text)
        assertEquals(R.string.finish, text.actualText)
    }
}

private class FakeText : UpdateCustomTextView {

    var actualText = 0

    override fun update(resId: Int) {
        actualText = resId
    }
}
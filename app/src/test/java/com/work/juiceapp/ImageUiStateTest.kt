package com.work.juiceapp

import org.junit.Assert.*
import org.junit.Test

class ImageUiStateTest {
    @Test
    fun testInit() {
        val value = ImageUiState.Initial
        val image = FakeImage()
        value.update(image)

        assertEquals(R.drawable.tree, image.actualId)
        assertEquals(false, image.actualClickableState)
    }

    @Test
    fun testSqueeze() {
        val value = ImageUiState.Squeeze
        val image = FakeImage()
        value.update(image)

        assertEquals(R.drawable.lemon, image.actualId)
        assertEquals(true, image.actualClickableState)
    }

    @Test
    fun testProcess() {
        val value = ImageUiState.Process
        val image = FakeImage()
        value.update(image)

        assertEquals(R.drawable.lemon, image.actualId)
        assertEquals(false, image.actualClickableState)
    }

    @Test
    fun testMade() {
        val value = ImageUiState.Made
        val image = FakeImage()
        value.update(image)

        assertEquals(R.drawable.lemonade, image.actualId)
        assertEquals(false, image.actualClickableState)
    }

    @Test
    fun testFinish() {
        val value = ImageUiState.Finish
        val image = FakeImage()
        value.update(image)

        assertEquals(R.drawable.glass, image.actualId)
        assertEquals(false, image.actualClickableState)
    }
}

private class FakeImage() : UpdateCustomImageButton {

    override fun updateUiState(outer: ImageUiState) {
    }

    var actualId = 0
    var actualClickableState = false

    override fun updateUi(resId: Int, clickable: Boolean) {
        actualId = resId
        actualClickableState = clickable
    }
}
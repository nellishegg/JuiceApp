package com.work.juiceapp

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.os.Build


class ImageSaveState : View.BaseSavedState {

    private lateinit var state: ImageUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ImageUiState::class.java.classLoader,
                ImageUiState::class.java
            ) as ImageUiState
        } else {
            parcelIn.readSerializable() as ImageUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ImageUiState = state

    fun save(uiState: ImageUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ImageSaveState> {
        override fun createFromParcel(parcel: Parcel): ImageSaveState =
            ImageSaveState(parcel)

        override fun newArray(size: Int): Array<ImageSaveState?> =
            arrayOfNulls(size)
    }
}

package com.work.juiceapp

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.os.Build


class ActionSaveState : View.BaseSavedState {

    private lateinit var state: ButtonUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ButtonUiState::class.java.classLoader,
                ButtonUiState::class.java
            ) as ButtonUiState
        } else {
            parcelIn.readSerializable() as ButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ButtonUiState = state

    fun save(uiState: ButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ActionSaveState> {
        override fun createFromParcel(parcel: Parcel): ActionSaveState =
            ActionSaveState(parcel)

        override fun newArray(size: Int): Array<ActionSaveState?> =
            arrayOfNulls(size)
    }
}

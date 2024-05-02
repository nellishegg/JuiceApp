package com.work.juiceapp

import android.app.Application
import android.content.Context

class App : Application() {

    lateinit var viewModel: GameViewModel


    override fun onCreate() {
        super.onCreate()
        val permanentStorage = PermanentStorage.Base(
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        )
        viewModel = GameViewModel(Repository.Base(IntCache.Base(permanentStorage, "key", 0)))
    }
}
package com.work.juiceapp

import android.app.Application

class App: Application() {

    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = GameViewModel(Repository.Base())
    }
}
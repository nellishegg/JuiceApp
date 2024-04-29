package com.work.juiceapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.work.juiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState

        val gameViewModel = GameViewModel(Repository.Base())

        binding.mainButton.setOnClickListener {
            uiState = uiState.handleAction(gameViewModel)
            uiState.update(binding)
        }

        binding.imageButton.setOnClickListener {
            uiState = gameViewModel.handleImage()
            uiState.update(binding)
        }
        uiState = gameViewModel.init()
        uiState.update(binding)


    }
}
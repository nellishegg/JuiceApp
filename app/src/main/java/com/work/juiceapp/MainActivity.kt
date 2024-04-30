package com.work.juiceapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.work.juiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var uiState: UiState

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameViewModel = (application as App).viewModel

        binding.mainButton.setOnClickListener {
            uiState = binding.mainButton.handleAction(gameViewModel)
            uiState.update(binding)
        }

        binding.imageButton.setOnClickListener {
            uiState = gameViewModel.handleImage()
            uiState.update(binding)
        }
        if (savedInstanceState == null) {
            uiState = gameViewModel.init()
            uiState.update(binding)
        }
    }

}

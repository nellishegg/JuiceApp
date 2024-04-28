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
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameViewModel = GameViewModel()

        binding.mainButton.setOnClickListener {
            val uiState: UiState = gameViewModel.handleButton()
            uiState.update(binding)
        }

        binding.imageViewId.setOnClickListener {
            val uiState: UiState = gameViewModel.handleImage()
            uiState.update(binding)
        }
        val uiState: UiState = gameViewModel.init()
        uiState.update(binding)


    }
}
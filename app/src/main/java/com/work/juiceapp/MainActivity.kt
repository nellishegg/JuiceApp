package com.work.juiceapp

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.work.juiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var uiState: UiState
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val gameViewModel = (application as App).viewModel

        binding.mainButton.setOnClickListener {
            uiState = uiState.handleAction(gameViewModel)
            uiState.update(binding)
        }

        binding.imageButton.setOnClickListener {
            uiState = gameViewModel.handleImage()
            uiState.update(binding)
        }
        if (savedInstanceState == null) {
            uiState = gameViewModel.init()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                uiState = savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
            } else {
                uiState = savedInstanceState.getSerializable(KEY) as UiState
            }
        }
        uiState.update(binding)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    companion object {
        const val KEY = "uiStateKey"
    }
}

package com.example.mobile1project

import SumAppView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.IMC.Views.BMIScreen
import com.example.mobile1project.IMC.viewmodels.BMIViewModel
import com.example.mobile1project.sum.viewmodel.SumViewModel
import com.example.mobile1project.ui.theme.Mobile1ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobile1ProjectTheme {
                val bmiViewModel: BMIViewModel = viewModel() // ViewModel correcto
                // ✅ ViewModel aquí, fuera del Scaffold
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Puedes usar innerPadding si lo necesitas
                    BMIScreen(viewModel = bmiViewModel)
                }
            }
        }
    }
}

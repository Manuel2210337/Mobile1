package com.example.mobile1project

import SumAppView
import TemperatureViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.ids.IMC.Views.BMIScreen
import com.example.mobile1project.ids.IMC.viewmodels.BMIViewModel
import com.example.mobile1project.ids.grados_Celsius.Views.TemperatureConverterScreen
import com.example.mobile1project.ids.sum.viewmodel.SumViewModel
import com.example.mobile1project.navigation.TabBarNavigationView
import com.example.mobile1project.ui.theme.Mobile1ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobile1ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TabBarNavigationView()
                }
            }
        }
    }
}


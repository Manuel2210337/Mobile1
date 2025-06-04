package com.example.mobile1project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mobile1project.ids.restaurantes.navigation.NavGraph // ✅ importa tu NavGraph, no la del sistema
import com.example.mobile1project.ids.restaurantes.viewmodels.RestauranteViewModel
import com.example.mobile1project.ui.theme.Mobile1ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1ProjectTheme {
                val navController = rememberNavController()
                val viewModel: RestauranteViewModel = viewModel()

                Surface(color = MaterialTheme.colorScheme.background) {
                    NavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}




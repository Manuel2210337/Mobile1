package com.example.mobile1project.ids

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile1project.navigation.AppScreenNavigation
import com.example.mobile1project.navigation.ScreenNavigation



@Composable
fun IdsView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { navController.navigate(ScreenNavigation.FirstPartial.route) }) {
            Text(text = "Ir al Primer Parcial")
        }

        Button(onClick = { navController.navigate(AppScreenNavigation.SecondPartial.route) }) {
            Text(text = "Ir al Segundo Parcial")
        }

        Button(onClick = { navController.navigate(AppScreenNavigation.ThirdPartial.route) }) {
            Text(text = "Ir al Tercer Parcial")
        }
    }
}


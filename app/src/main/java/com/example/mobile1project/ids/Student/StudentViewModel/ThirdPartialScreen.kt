package com.example.mobile1project.ids.Student.StudentViewModel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdPartialScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Tercer Parcial") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate("student_list") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Lista de Estudiantes")
            }
        }
    }
}



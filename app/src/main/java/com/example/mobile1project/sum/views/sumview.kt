package com.example.mobile1project.sum.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.mobile1project.sum.viewmodel.SumViewModel

@Composable
fun SumApp(viewModel: SumViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = viewModel.num1,
            onValueChange = { viewModel.num1 = it },
            label = { Text("Número 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.num2,
            onValueChange = { viewModel.num2 = it },
            label = { Text("Número 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.calculateSum() }) {
            Text("Sumar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Resultado: ${viewModel.result}", style = MaterialTheme.typography.bodyLarge)
    }
}

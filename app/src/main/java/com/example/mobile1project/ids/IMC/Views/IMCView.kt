package com.example.mobile1project.ids.IMC.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile1project.ids.IMC.viewmodels.BMIViewModel
import com.example.mobile1project.R

@Composable
fun BMIScreen(viewModel: BMIViewModel) {
    val resources = LocalContext.current.resources

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = viewModel.weight,
            onValueChange = { viewModel.weight = it },
            label = { Text(stringResource(R.string.enter_weight)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.height,
            onValueChange = { viewModel.height = it },
            label = { Text(stringResource(R.string.enter_height)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.calculateBMI(resources) }) {
            Text(stringResource(R.string.calculate_bmi))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = viewModel.bmiResult)
    }
}

class MainActivity : ComponentActivity() {
    private val bmiViewModel: BMIViewModel by viewModels() // Instancia del ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIScreen(viewModel = bmiViewModel)
        }
    }
}

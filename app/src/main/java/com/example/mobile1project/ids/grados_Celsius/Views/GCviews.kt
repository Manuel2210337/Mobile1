package com.example.mobile1project.ids.grados_Celsius.Views

import TemperatureViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile1project.R

@Composable
fun TemperatureConverterScreen(viewModel: TemperatureViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.termometro),
            contentDescription = stringResource(R.string.thermometer)

        )
        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = viewModel.celsius,
            onValueChange = { viewModel.celsius = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.convertTemperature() }) {
            Text(text = stringResource(R.string.convert))


        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Resultado: ${viewModel.fahrenheit} °F")


    }
}

class MainActivity : ComponentActivity() {
    private val temperatureViewModel: TemperatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverterScreen(viewModel = temperatureViewModel)
        }
    }
}


package com.example.mobile1project.IMC.viewmodels

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import kotlin.math.pow

// ViewModel
class BMIViewModel : ViewModel() {
    var weight by mutableStateOf("")
    var height by mutableStateOf("")
    var bmiResult by mutableStateOf("")

    fun calculateBMI(resources: Resources) {
        val weightValue = weight.toFloatOrNull()
        val heightValue = height.toFloatOrNull()

        if (weightValue != null && heightValue != null && heightValue > 0) {
            val bmi = weightValue / heightValue.pow(2)
            bmiResult = if (bmi in 19.0..24.9) {
                resources.getString(R.string.bmi_normal)
            } else {
                resources.getString(R.string.bmi_not_normal)
            }
        } else {
            bmiResult = resources.getString(R.string.invalid_input)
        }
    }
}
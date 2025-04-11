// ViewModel.kt
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mobile1project.ids.grados_Celsius.Views.TemperatureConverterScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class TemperatureViewModel : ViewModel() {
    var celsius by mutableStateOf("")
    var fahrenheit by mutableStateOf("")

    fun convertTemperature() {
        val celsiusValue = celsius.toFloatOrNull()
        fahrenheit = if (celsiusValue != null) {
            String.format("%.1f", (celsiusValue * 9 / 5) + 32)
        } else {
            "Entrada inválida"
        }
    }
}







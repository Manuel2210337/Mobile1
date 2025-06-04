import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile1project.thirdpartial.TercerParcial.EstudianteApiService
import com.example.mobile1project.thirdpartial.TercerParcial.models.Estudiante
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class EstudianteViewModel : ViewModel() {

    // Crear la instancia del API Service
    private val apiService = EstudianteApiService.create()

    private val _estudiantes = MutableStateFlow<List<Estudiante>>(emptyList())
    val estudiantes: StateFlow<List<Estudiante>> = _estudiantes

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun setError(message: String) {
        _errorMessage.value = message
    }

    fun obtenerEstudiantes() {
        viewModelScope.launch {
            try {
                // Llamar al API y actualizar el estado
                val resultado = apiService.getEstudiantes()
                _estudiantes.value = resultado
                _errorMessage.value = null
            } catch (e: IOException) {
                setError("Sin conexión a Internet")
            } catch (e: HttpException) {
                when (e.code()) {
                    404 -> setError("Error 404: No encontrado")
                    500 -> setError("Error 500: Error del servidor")
                    else -> setError("Error desconocido: ${e.code()}")
                }
            } catch (e: Exception) {
                setError("Error inesperado")
            }
        }
    }
}

package com.example.mobile1project.thirdpartial.TercerParcial.viewmodels

import EstudianteViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import kotlinx.coroutines.launch
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstudianteListScreen(viewModel: EstudianteViewModel = viewModel()) {
    val estudiantes = viewModel.estudiantes.collectAsState(initial = emptyList())
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Estado para mensajes de error
    val errorMessage by viewModel.errorMessage.collectAsState(initial = null)

    // Mostrar el snackbar si hay error
    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(it)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mostrar Estudiantes") }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    try {
                        viewModel.obtenerEstudiantes()
                    } catch (e: IOException) {
                        viewModel.setError("Sin conexión a Internet")
                    } catch (e: Exception) {
                        when ((e.message ?: "").toIntOrNull()) {
                            404 -> viewModel.setError("Error 404: No encontrado")
                            500 -> viewModel.setError("Error 500: Error del servidor")
                            else -> viewModel.setError("Error desconocido")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cargar estudiantes")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(estudiantes.value) { estudiante ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            val imageNameRaw = estudiante.imageName ?: "default_image"
                            val imageName = imageNameRaw
                                .substringBeforeLast('.')
                                .lowercase()

                            val imageId = context.resources.getIdentifier(
                                imageName,
                                "drawable",
                                context.packageName
                            )

                            if (imageId != 0) {
                                Image(
                                    painter = painterResource(id = imageId),
                                    contentDescription = "Foto de ${estudiante.name}",
                                    modifier = Modifier.size(64.dp)
                                )
                            } else {
                                // Mostrar mensaje de imagen no encontrada
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        painter = painterResource(id = R.drawable.default_image),
                                        contentDescription = "Imagen por defecto",
                                        modifier = Modifier.size(64.dp)
                                    )
                                    Text(
                                        text = "Imagen no encontrada",
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Column {
                                Text(text = "Nombre: ${estudiante.name}")
                                Text(text = "Matrícula: ${estudiante.studentId}")
                                Text(text = "Frase: ${estudiante.quote}")
                            }
                        }
                    }
                }
            }
        }
    }
}

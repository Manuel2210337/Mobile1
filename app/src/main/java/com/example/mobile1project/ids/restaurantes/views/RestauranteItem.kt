package com.example.mobile1project.ids.restaurantes.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile1project.ids.restaurantes.models.Restaurante

@Composable
fun RestauranteItem(
    restaurante: Restaurante,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = restaurante.nombre ?: "Sin nombre", style = MaterialTheme.typography.titleMedium)
            Text(text = "Calificación: ${restaurante.calificacion ?: "?"}")
            Text(text = "Costo de envío: $${restaurante.costoEnvio ?: "?"}")
            Text(text = "Tiempo de entrega: ${restaurante.tiempoEntrega ?: "?"} min")
        }

    }
}

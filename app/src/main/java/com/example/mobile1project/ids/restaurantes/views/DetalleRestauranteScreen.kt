package com.example.mobile1project.ids.restaurantes.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mobile1project.ids.restaurantes.models.Restaurante


@Composable
fun RestauranteDetalleScreen(
    restaurante: Restaurante,
    onLlamarClick: () -> Unit,
    onSitioWebClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Imagen del restaurante
        AsyncImage(
            model = restaurante.imagenUrl,
            contentDescription = restaurante.nombre,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        // Nombre del restaurante
        Text(
            text = restaurante.nombre ?: "Sin nombre",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(16.dp)
        )

        // Mapa (placeholder por ahora)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Mapa aquí", modifier = Modifier.align(Alignment.Center))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botones de acción
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(onClick = onLlamarClick) {
                Icon(Icons.Filled.Call, contentDescription = "Llamar")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Llamar")
            }

            OutlinedButton(onClick = onSitioWebClick) {
                Icon(Icons.Filled.Language, contentDescription = "Sitio Web")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sitio Web")
            }
        }
    }
}


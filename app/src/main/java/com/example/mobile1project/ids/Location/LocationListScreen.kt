package com.example.mobile1project.ids.Location

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.ids.Location.LocationViewModel
import com.example.mobile1project.ids.Location.Location


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationListScreen(viewModel: LocationViewModel = viewModel()) {
    val locations = viewModel.locations.collectAsState(initial = emptyList<Location>())


    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Locations List") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(locations.value) { location ->
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = context.resources.getIdentifier(location.imageUrl.lowercase(), "drawable", context.packageName)),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(text = "Name: ${location.name}")
                            Text(text = "Address: ${location.address}")
                            Text(text = "Lat: ${location.latitude}, Lng: ${location.longitude}")
                        }
                    }
                }
            }
        }
    }
}

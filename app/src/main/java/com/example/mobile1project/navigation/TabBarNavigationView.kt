package com.example.mobile1project.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mobile1project.ids.IdsView
import com.example.mobile1project.firstpartial.FirstPartialView
import com.example.mobile1project.ids.Student.StudentViewModel.StudentListScreen
import com.example.mobile1project.secondpartial.SecondPartialView
import com.example.mobile1project.thirdpartial.ThirdPartialView

sealed class ScreenNavigation(val route: String, val label: String, val icon: ImageVector) {
    object Ids : ScreenNavigation("ids", "IDs", Icons.Default.List)
    object FirstPartial : ScreenNavigation("first_partial", "Parcial 1", Icons.Default.Info)
    object ThirdPartial : ScreenNavigation("third_partial", "Tercer Parcial", Icons.Default.List)
}

@Composable
fun TabBarNavigationView(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        ScreenNavigation.Ids,
        ScreenNavigation.FirstPartial,
        ScreenNavigation.ThirdPartial  // Asegúrate de agregar la ruta del tercer parcial
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.ThirdPartial.route, // Utiliza el ScreenNavigation en lugar de una ruta hardcodeada
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNavigation.Ids.route) { IdsView(navController) }
            composable(ScreenNavigation.FirstPartial.route) { FirstPartialView() }
            composable(AppScreenNavigation.SecondPartial.route) { SecondPartialView() }
            composable(ScreenNavigation.ThirdPartial.route) { ThirdPartialView(navController) }
            composable("student_list") { StudentListScreen() }
        }
    }
}

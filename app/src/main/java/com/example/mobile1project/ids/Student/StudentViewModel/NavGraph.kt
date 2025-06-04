package com.example.mobile1project.ids.Student.StudentViewModel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "third_partial") {
        composable("third_partial") {
            ThirdPartialScreen(navController)
        }
        composable("student_list") {
            StudentListScreen()
        }
    }
}

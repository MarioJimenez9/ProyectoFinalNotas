package com.example.notesapp.componentes

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.notesapp.R
import com.example.notesapp.Screen

@Composable
fun BarraNavegacionBottom(navController: NavController?) {
    val items = listOf(
        Screen.MainScreen.route
    )
    BottomNavigation(
        backgroundColor = Color.Cyan,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            label = { Text(text = "Home") },
            selected = true,
            onClick = { navController?.navigate(Screen.MainScreen.route) },
            icon = {Icon(Icons.Filled.Home,"")}
        )
        BottomNavigationItem(
            label = { Text(text = "Notas") },
            selected = true,
            onClick = { navController?.navigate(Screen.VistaNotas.route) },
            icon = {Icon(Icons.Filled.CheckCircle,"")}
        )
        BottomNavigationItem(
            label = { Text(text = "Tareas") },
            selected = true,
            onClick = { navController?.navigate(Screen.VistaTareas.route) },
            icon = {Icon(Icons.Filled.DateRange,"")}
        )
    }
}

@Composable
@Preview
fun BarraNavegacionBottomPreview(){
    BarraNavegacionBottom(null)
}
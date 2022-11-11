package com.example.notesapp.componentes

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.notesapp.R
import com.example.notesapp.Screen

@Composable
fun BarraNavegacionBottom(navController: NavHostController) {
    val items = listOf(
        Screen.MainScreen.route
    )
    var tareas = stringResource(id = R.string.tasks)
    var principal = stringResource(id = R.string.home)
    var notas = stringResource(id = R.string.notes)
    val currentRoute = currentRoute(navController)
    BottomNavigation(
        backgroundColor = Color.Cyan,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            label = { Text(text = principal) },
            selected = currentRoute == Screen.MainScreen.route,
            onClick = {
                navController.navigate(Screen.MainScreen.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                }
            },
            icon = {Icon(Icons.Filled.Home,"")}
        )
        BottomNavigationItem(
            label = { Text(text = notas) },
            selected = currentRoute == Screen.VistaNotas.route,
            onClick = {
                navController.navigate(Screen.VistaNotas.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                }
            },
            icon = {Icon(Icons.Filled.CheckCircle,"")}
        )
        BottomNavigationItem(
            label = { Text(text = tareas) },
            selected = currentRoute == Screen.VistaTareas.route,
            onClick = {
                navController.navigate(Screen.VistaTareas.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                }
            },
            icon = {Icon(Icons.Filled.DateRange,"")}
        )
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route;
}

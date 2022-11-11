package com.example.notesapp.componentes

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.notesapp.Screen

@Composable
fun BarraNavegacionBottomMedia(
    navController: NavController?,
    id : String
) {
    val items = listOf(
        Screen.MainScreen.route
    )
    BottomNavigation(
        backgroundColor = Color.Cyan,
        contentColor = Color.White
    ) {

        BottomNavigationItem(
            label = { Text(text = "nuevo recordatorio") },
            selected = true,
            onClick = { navController?.navigate(Screen.VistaRecordatorios.withArgs(id)){
                popUpTo(navController.graph.findStartDestination().id){
                    saveState = true
                }
                launchSingleTop = true
            }  },
            icon = { Icon(Icons.Filled.Favorite,"") }
        )
        BottomNavigationItem(
            selected = true,
            label = { Text(text = "agregar media")},
            onClick = { navController?.navigate(Screen.VistaMedia.withArgs(id)){
                popUpTo(navController.graph.findStartDestination().id){
                    saveState = true
                }
                launchSingleTop = true
            } },
            icon = { Icon(Icons.Filled.PlayArrow, "") }
        )
    }
}

@Composable
@Preview
fun BarraNavegacionBottomMediaPreview(){
    BarraNavegacionBottomMedia(null,"1")
}
package com.example.notesapp.ui.vistas

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.notesapp.R
import com.example.notesapp.datos.Media
import com.example.notesapp.datos.NotasBD

@Composable
fun MultimediaScreen(noteID: String, navController: NavController) {
    val dialogAgregarMultimedia = remember { mutableStateOf(false) }
    var nombreArchivo = remember { mutableStateOf("") }
    if (dialogAgregarMultimedia.value) {
        MuestraDialogAgregarMultimedia(
            dialogAgregarMultimedia,
            nombreArchivo,
            noteID,
            navController
        )
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { dialogAgregarMultimedia.value = true }) {
                Icon(Icons.Filled.Add, null)
            }
        },
    ) {
        Surface(color = MaterialTheme.colors.background) {
            MultimediaDetails(noteID, navController)
        }
    }
}

@Composable
fun MuestraDialogAgregarMultimedia(
    dialogState: MutableState<Boolean>,
    nombreArchivo: MutableState<String>,
    noteID: String,
    navController: NavController
) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = {
            dialogState.value = false
            nombreArchivo.value = ""
        },
        title = {
//            Text(text = stringResource(R.string.ADD_NOTE))
            Text(stringResource(R.string.ADD_MEDIA))
        },
        text = {
            Text(stringResource(R.string.ADD_MEDIA_QUESTION))
        },
        buttons = {
            Column(
                modifier = Modifier.padding(all = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        val idNuevaMultimedia =
                            insertaMultimedia(context, noteID, "", "jpg", nombreArchivo.value)
                        dialogState.value = false
                        nombreArchivo.value = ""
                        navController.navigate(route = "detallesFoto/${idNuevaMultimedia}")
                    }
                ) {
                    Text(stringResource(R.string.PICTURE))
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        val idNuevaMultimedia =
                            insertaMultimedia(context, noteID, "", "mp4", nombreArchivo.value)
                        dialogState.value = false
                        nombreArchivo.value = ""
                        navController.navigate(route = "detallesVideo/$idNuevaMultimedia")
                    }
                ) {
                    Text(stringResource(R.string.VIDEO))
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        val idNuevaMultimedia =
                            insertaMultimedia(context, noteID, "", "mp3", nombreArchivo.value)
                        dialogState.value = false
                        nombreArchivo.value = ""
                        navController.navigate(route = "detallesAudio/$idNuevaMultimedia")
                    }
                ) {
                    Text(stringResource(R.string.AUDIO))
                }
            }
        }
    )
}

fun insertaMultimedia(
    context: Context, idNota: String, descripcion: String, tipo: String,
    nombre: String
): Long {
    val multimedia =
        Media(idNota = idNota.toLong(), descripcion = descripcion, ruta = nombre, tipo = tipo)
    val db = NotasBD.getInstance(context)
    db.DAONotas().save(multimedia)

    return db.DAONotas().getMultimediasPorIDNota(idNota).last().idMultimedia
}

@Composable
fun MultimediaDetails(noteID: String, navController: NavController) {
    val context = LocalContext.current
    val db = NotasBD.getInstance(context)
    val multimedias = db.DAONotas().getLiveMultimediasPorIDNota(noteID).observeAsState()
    Column {
        Column() {
            multimedias.value?.forEach { n -> GetMultimedia(n, navController, context) }
        }
    }
}

@Composable
fun GetMultimedia(
    multimedia: Media,
    navController: NavController,
    context: Context
) {
    var ruta = "";
    if (multimedia.tipo == "jpg") ruta = "detallesFoto/${multimedia.idMultimedia}"
    if (multimedia.tipo == "mp4") ruta = "detallesVideo/${multimedia.idMultimedia}"
    if (multimedia.tipo == "mp3") ruta = "detallesAudio/${multimedia.idMultimedia}"
    if (multimedia.tipo == "etc") ruta = "detallesArchivo/${multimedia.idMultimedia}"
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                navController.navigate(route = ruta)
            },
        elevation = 10.dp
    ) {
        Column {
            if (multimedia.tipo == "jpg") Text(stringResource(R.string.PICTURE))
            if (multimedia.tipo == "mp4") Text(stringResource(R.string.VIDEO))
            if (multimedia.tipo == "mp3") Text(stringResource(R.string.AUDIO))
            if (multimedia.descripcion.isNotBlank())
                Text(
                    multimedia.descripcion,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
        }
    }
}
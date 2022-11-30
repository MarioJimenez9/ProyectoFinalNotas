package com.example.notesapp.datos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas")
data class Nota(
    @PrimaryKey(autoGenerate = true)
    var idNota: Long = 0L,
    var titulo: String = "",
    var descripcion: String = "",
    var nota: String = "",
    var fechaCreacion: Long,
    var esTarea: Boolean,
    var fechaLimite: Long = 0,
    var estaCompletada: Boolean = false,
)
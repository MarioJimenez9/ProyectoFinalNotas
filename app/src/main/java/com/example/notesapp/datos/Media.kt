package com.example.notesapp.datos

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

import androidx.room.ColumnInfo

@Entity(
    tableName = "multimedias"
)
data class Media(
    @PrimaryKey(autoGenerate = true)
    var idMultimedia: Long = 0L,
    @ColumnInfo(index = true)
    var idNota: Long = 0L,
    var descripcion: String,
    var ruta: String,
    var tipo: String
)
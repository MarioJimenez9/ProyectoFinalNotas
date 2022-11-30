package com.example.notesapp.datos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(
    tableName = "recordatorios"
)
data class Recordatorio(
    @PrimaryKey(autoGenerate = true)
    var idRecordatorio: Long = 0L,
    @ColumnInfo(index = true)
    var idNota: Long = 0L,
    var fechaRecordatorio: Long,



    )

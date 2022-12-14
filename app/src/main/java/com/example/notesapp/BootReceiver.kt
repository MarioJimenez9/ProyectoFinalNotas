package com.example.notesapp

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.notesapp.datos.Nota
import com.example.notesapp.datos.NotasBD
import com.example.notesapp.datos.Recordatorio
import java.time.LocalDateTime
import java.time.ZoneId

class BootReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        val db = NotasBD.getInstance(context)
        val recordatorios = db.DAONotas().getRecordatorios()
        val time = LocalDateTime.now();
        val zoneId = ZoneId.systemDefault();
        val fechaActual = time.atZone(zoneId).toEpochSecond();
        recordatorios.forEach {
            if(fechaActual >= it.fechaRecordatorio)
                agendaRecordatorio(context, it)
        }
        val notas = db.DAONotas().getNotas()
        notas.forEach {
            if(it.esTarea && fechaActual >= it.fechaLimite)
                agendaNota(context, it)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun agendaRecordatorio(context: Context, recordatorio: Recordatorio) {
        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, MiReceiverAlarma::class.java).let { intent ->
            intent.putExtra("idRecordatorio", recordatorio.idRecordatorio)
            intent.putExtra("idNota", recordatorio.idNota)
            PendingIntent.getBroadcast(context, recordatorio.idRecordatorio.toInt(), intent, 0)
        }

        alarmMgr.set(
            AlarmManager.RTC,
            recordatorio.fechaRecordatorio,
            alarmIntent
        )
    }
    private fun agendaNota(context: Context, nota: Nota) {
        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, MiReceiverAlarma::class.java).let { intent ->
            intent.putExtra("idNota", nota.idNota)
            intent.putExtra("esFechaLimite", true)
            PendingIntent.getBroadcast(context, (nota.idNota).toInt(), intent, 0)
        }
        alarmMgr.set(
            AlarmManager.RTC,
            nota.fechaLimite,
            alarmIntent
        )
    }
}
package com.example.notesapp.viewmodel

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.Fecha
import java.time.LocalDate
import java.util.*

class SpinnerViewModel : ViewModel(){
    @RequiresApi(Build.VERSION_CODES.O)
    var tmpFecha = Fecha(LocalDate.now().year,LocalDate.now().monthValue,LocalDate.now().dayOfMonth + 1,
        0,0)
    @RequiresApi(Build.VERSION_CODES.O)
    private val _time = MutableLiveData(tmpFecha)
    @RequiresApi(Build.VERSION_CODES.O)
    var time : LiveData<Fecha> = _time

    fun selectDateTime(context: Context){
        var time = ""
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)

        DatePickerDialog(context, { _, year, month, day ->
            TimePickerDialog(context, { _, hour, minute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(year, month, day, hour, minute)
                val monthStr: String
                if ((month + 1).toString().length == 1) {
                    monthStr = "0${month + 1}"
                } else {
                    monthStr = month.toString()
                }
                time = "$day - $monthStr - $year $hour:$minute"
                var fechaSeleccionada = Fecha(year,month,day,hour,minute)
                updateDateTime(fechaSeleccionada)
            }, startHour, startMinute, false).show()
        }, startYear, startMonth, startDay).show()
    }

    private fun updateDateTime(dateTime: Fecha) {
        _time.value = dateTime
    }
}
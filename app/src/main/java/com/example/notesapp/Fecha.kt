package com.example.notesapp

class Fecha (
    var year: Int,
    var month: Int,
    var day: Int,
    var hour: Int,
    var minute: Int
) {

    fun imprimir() : String {
        var hourFormat : String
        if(hour < 10){
            hourFormat = "0$hour"
        }
        else hourFormat = "$hour"
        if(minute < 10){
            hourFormat += ":0$minute"
        }
        else hourFormat += ":-$minute";
        return "$day/$month/$year - $hourFormat"
    }

}
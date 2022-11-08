package com.example.notesapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.notesapp.datos.NotasDatabase
import java.util.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                checarNotificaciones()
            }
        }, 0, 60000)
        setContent {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
        }
    }

    fun checarNotificaciones (){
        //Log.e("miDebug","vvvvvv")
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)

        //val contex = LocalContext.current;
        val db = NotasDatabase.getDatabase(this);
        var notas = db.notaDao().getTodos()

        for (nota in notas){
            Log.e("miDebug",nota.titulo)
            var idNota = nota.id
            var recordatorios = db.notaDao().getRecordatorios(idNota)
            for (recordatorio in recordatorios){
                var fecha = recordatorio.Fecha
                val strs = fecha.split(" - ").toTypedArray()

                var date = strs[0].split("/").toTypedArray()
                var tiempo = strs[1].split(":").toTypedArray()

                var year = date[2].toInt()
                var month = date[1].toInt()
                var day = date[0].toInt()

                var hour = tiempo[0].toInt()
                var minute = tiempo[1].dropLast(1).toInt()

                if(minute != null){
                    //Log.e("miDebug1","dfas")
                    //Toast.makeText(this, minute.toString() + ":" , Toast.LENGTH_SHORT).show()
                }

                if(
                    year == startYear &&
                    month == startMonth &&
                    day == startDay &&
                    hour == startHour &&
                    minute == startMinute
                ){
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    Button(onClick = { /*TODO*/ }) {
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}
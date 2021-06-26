package com.example.foodtower

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        imageButton?.setOnClickListener {
            val homepage = Intent(this@MainActivity,homepage::class.java)
            startActivity(homepage)
        }

        var intentAlarm = Intent (this, InformationWidget::class.java).let {
            it.action = InformationWidget.ACTION_AUTO_UPDATE
            PendingIntent.getBroadcast(this, 101, it, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        var cal = Calendar.getInstance()
        cal.add(Calendar.SECOND, 5)
        var alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(AlarmManager.RTC, cal.timeInMillis, 5000L, intentAlarm)
        Log.e("Alarm Start","Alarm Start")
    }
}
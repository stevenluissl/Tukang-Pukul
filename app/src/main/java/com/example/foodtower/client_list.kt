package com.example.foodtower

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_client_list.*
import java.util.*

class client_list : AppCompatActivity() {
    var mAlarmManager : AlarmManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_list)
        //alarm manager untuk mengset alarm yang akan di notifikasi jika waktu tersebut sudah habis
        mAlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        buttonconfirm.setOnClickListener{
            var alarmTimer = Calendar.getInstance()
            //mengset alarm selama 10 detik jika sesudah 10 detik maka akan muncul notifikasi
            alarmTimer.add(Calendar.SECOND,10)
            //menjalankan sendintent di broadcastreceiver
            var sendIntent = Intent(this,BroadcastReceiver::class.java)

            var mPendingIntent = PendingIntent.getBroadcast(this,101,sendIntent,0)

            mAlarmManager?.set(AlarmManager.RTC,alarmTimer.timeInMillis,mPendingIntent)
            Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show()
        }


        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val chefpage = Intent(this@client_list,chef_page::class.java)
            startActivity(chefpage)
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@client_list,homepage::class.java)
            startActivity(homepage)
        }
    }
}
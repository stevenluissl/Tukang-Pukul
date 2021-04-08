package com.example.foodtower

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class BroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
//notif akan di panggil jika ada id unik tersebut
        val Notifid = 12345
//channel id untuk menandai bahwa channel tersebut yang akan di notif
        val Channel_id = "my_channel1"
//nama channel notif
        val name = "ON/OFF"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val nNotifyChannel = NotificationChannel(Channel_id,name,importance)
        var mBuilder = NotificationCompat.Builder(context,Channel_id)
//menambahkan foto pada notification
            .setSmallIcon(R.drawable.ic_launcher_round)
//judul untuk notification
            .setContentTitle("Alarm Manager")
//priority untuk mendahulukan notifikasi
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        var mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//masuk ke dalam perulangan jika tombol yang di klik akan memunculkan notif tersebut
        for (s in mNotificationManager.notificationChannels)
        {
            mNotificationManager.deleteNotificationChannel(s.id)
        }
//mengcreate notification channel
        mNotificationManager.createNotificationChannel(nNotifyChannel)
//menghubungkan notification channel
        mNotificationManager.notify(Notifid,mBuilder.build())
    }
}
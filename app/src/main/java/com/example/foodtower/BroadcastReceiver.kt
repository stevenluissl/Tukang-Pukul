package com.example.foodtower

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class BroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val Notifid = 12345
        val Channel_id = "my_channel1"
        val name = "ON/OFF"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val nNotifyChannel = NotificationChannel(Channel_id,name,importance)
        var mBuilder = NotificationCompat.Builder(context,Channel_id)
            .setSmallIcon(R.drawable.ic_launcher_round)
            .setContentTitle("Alarm Manager")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        var mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        for (s in mNotificationManager.notificationChannels)
        {
            mNotificationManager.deleteNotificationChannel(s.id)
        }
        mNotificationManager.createNotificationChannel(nNotifyChannel)
        mNotificationManager.notify(Notifid,mBuilder.build())
    }
}
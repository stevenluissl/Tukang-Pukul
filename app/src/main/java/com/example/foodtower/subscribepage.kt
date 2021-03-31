package com.example.foodtower

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.LauncherActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_subscribepage.*
import me.leolin.shortcutbadger.ShortcutBadger

class subscribepage : AppCompatActivity() {

//notification manager untuk memunculkan atau menghilangkan notification
    lateinit var notificationManager: NotificationManager
//notificationchannel kita bisa mengdisable atau able kan notifikasi di pengaturan
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelID = "com.example.vicky.notificationexample"
//notifikasi description akan menampilkan kepada pengguna
    private val description = "Test Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscribepage)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        reqinformation.setOnClickListener {

            val intent = Intent (this,LauncherActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            val intent2 = Intent (this,chefmenu::class.java).apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK }
            val ActionPendingIntent : PendingIntent = PendingIntent.getActivity(this, 0, intent2, 0)
            /*val pendingIntent2 = TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(intent2)
                getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
            }*/

            //coding ini akan dijalankan jika versi android yang dijalankan adalah versi Oreo
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelID,description,NotificationManager.IMPORTANCE_HIGH)
                //untuk memunculkan cahaya
                notificationChannel.enableLights(true)
                //untuk memunculkan warna pada cahaya
                notificationChannel.lightColor = Color.GREEN
                //membuat getaran jika ada notifikasi yang masuk
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)
                //setsShowBadge berfungsi untuk memunculkan Dot Notification
                //jika true maka Dot Notification tidak akan ditampilkan
                //jika false maka Dot Notification akan ditampilkan pada icon aplikasi
                notificationChannel.setShowBadge(false)

                builder = Notification.Builder(this,channelID)
                        //membuat title notifikasi
                    .setContentTitle("Code Android")
                        //membuat text notifikasi
                    .setContentText("Test Notification")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher_round))
                    .setContentIntent(pendingIntent)
                    //.setContentIntent(pendingIntent2)
                    .addAction(R.drawable.gmbr1,"View Menu", ActionPendingIntent)
            }
            else{
                builder = Notification.Builder(this)
                    .setContentTitle("Code Android")
                    .setContentText("Test Notification")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher_round))
                    .setContentIntent(pendingIntent)
                    //.setContentIntent(pendingIntent2)
                    .addAction(R.drawable.gmbr1,"View Menu", ActionPendingIntent)
            }
            //notification akan di panggil dan juga harus memiliki id yang unik juga
            notificationManager.notify(1234,builder.build())

        }

        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val chefmenu = Intent(this@subscribepage,chefmenu::class.java)
            startActivity(chefmenu)
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@subscribepage,homepage::class.java)
            startActivity(homepage)
        }
    }



//    fun getAlertDialog(view: View) {
//        var reqinformation = AlertDialog.Builder(this)
//            .setTitle("Alert")
//            .setMessage("Apakah anda ingin Request Information?")
//            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
//                Toast.makeText(this,"Request Berhasil", Toast.LENGTH_SHORT).show()
//            })
//            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
//                Toast.makeText(this,"", Toast.LENGTH_SHORT).show()
//            })
//        reqinformation.show()
//    }
}
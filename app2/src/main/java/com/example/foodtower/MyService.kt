package com.example.foodtower

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import java.lang.Exception

class MyService : Service() {
    //mengkomunikasikan data service ketika diaktifkan dari komponen lain
    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(Runnable {
            for (i in 1..5)
                try {
                    //membuat jeda thread setiap 300 milidetik
                    Thread.sleep(300L)
                }
                catch (e: Exception) {

                }
            stopSelf()
        }).start()
        //service hanya akan dijalankan sampai command selesai
        return START_NOT_STICKY
    }

    //setelah service selesai, akan ditampilkan pesan singkat
    override fun onDestroy() {
        Toast.makeText(this, "Vote berhasil", Toast.LENGTH_SHORT).show()
    }
}
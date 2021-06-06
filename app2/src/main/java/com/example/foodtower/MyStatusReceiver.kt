package com.example.foodtower

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class MyStatusReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // mmengecek apakah status setting airplane mode menyala atau tidak
        if(Settings.System.getInt(context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON, 0)==0){
                // jika status airplane mode mati maka akan mengeluarkan pop up "Flght Mode ; OFF" sekitar 1 detik
            Toast.makeText(context, "Flight Mode : OFF", Toast.LENGTH_SHORT).show()
        }
        else{
            // jika status airplane mode menyala maka akan mengeluarkan pop up "Flght Mode ; ON" sekitar 1 detik
            Toast.makeText(context, "Flight Mode : ON", Toast.LENGTH_SHORT).show()
        }
    }
}

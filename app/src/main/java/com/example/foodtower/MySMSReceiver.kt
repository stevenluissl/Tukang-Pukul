package com.example.foodtower

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast
import androidx.annotation.RequiresApi

class MySMSReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){
            var pdu = (intent.extras!!.get("pdus") as Array<*>).get(0)
            var myBundle = intent.extras
            var format = myBundle!!.getString("format")
            pdu.let{
                var message = SmsMessage.createFromPdu(it as ByteArray,format)
                var pesan = message.displayMessageBody
                var no_pengirim = message.displayOriginatingAddress
                Toast.makeText(context,"Phone : $no_pengirim \n" +
                        "Message : $pesan",  Toast.LENGTH_SHORT).show()
            }
        }
    }
}

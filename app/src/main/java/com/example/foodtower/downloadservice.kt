package com.example.foodtower

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.JobIntentService

class downloadservice : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
     var downloadProgress = 0
        do {
            Thread.sleep(100)
            downloadProgress+=10
            var intentFileDownload = Intent(ACTION_DOWNLOAD)
            intentFileDownload.putExtra(EXTRA_PERSEN,downloadProgress)
            intentFileDownload.putExtra(EXTRA_FINISH,false)
            if (downloadProgress>=100)
                intentFileDownload.putExtra(EXTRA_FINISH,true)
            sendBroadcast(intentFileDownload)
        }while (downloadProgress<100)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Selesai",Toast.LENGTH_SHORT).show()
    }

    companion object{
        fun enqueueWork(context: Context, intent: Intent){
            enqueueWork(context, downloadservice::class.java, JOB_ID_DOWNLOAD,intent)

        }
    }

}
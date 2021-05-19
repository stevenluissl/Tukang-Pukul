package com.example.foodtower

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.MediaStore
import android.widget.Toast

const val ACTION_PLAY = "PLAY"
const val ACTION_STOP = "STOP"
const val ACTION_CREATE = "CREATE"
class playmusic : Service(),
//memprepare data yang akan di baca dari awal sampai akhir
MediaPlayer.OnPreparedListener,
MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener{

    private var myMediaPlayer : MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null){
            var actionIntent = intent.action
            when(actionIntent){
                ACTION_CREATE -> {
                    //untuk membaca file yang akan di jalankan
                    myMediaPlayer = MediaPlayer()
                    myMediaPlayer?.setOnPreparedListener(this)
                    myMediaPlayer?.setOnCompletionListener(this)
                    myMediaPlayer?.setOnErrorListener(this)
                }
                //menjalankan file yang sudah di create (load)
                ACTION_PLAY -> {
                    if (!myMediaPlayer!!.isPlaying){
                        //membuka file pada folder raw
                        val assetFileDescriptor = this.resources
                            .openRawResourceFd(R.raw.ora)
                        myMediaPlayer?.run {
                            reset()
                            setDataSource(
                                assetFileDescriptor.fileDescriptor,
                                assetFileDescriptor.startOffset,
                                assetFileDescriptor.declaredLength
                            )
                            prepareAsync()
                        }
                    }
                }
                //untuk menghentikan putaran lagu yang sedang di baca
                ACTION_STOP ->{
                    myMediaPlayer?.stop()
                }
            }
        }
        return flags
    }
//data yang sudah di persiapkan atau di load
    override fun onPrepared(p0: MediaPlayer?) {
        myMediaPlayer?.start()
    }
//data yang sudah selesai di baca
    override fun onCompletion(p0: MediaPlayer?) {
        Toast.makeText(this,"File selesai di baca",Toast.LENGTH_SHORT).show()
    }
//permasalahan di dalam load file
    override fun onError(p0: MediaPlayer?, p1: Int, p2: Int): Boolean {
        Toast.makeText(this,"Error 404",Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        myMediaPlayer?.release()
    }
}
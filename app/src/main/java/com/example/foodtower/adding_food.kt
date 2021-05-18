package com.example.foodtower

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.Telephony
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_adding_food.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

private const val EXTRA_STATUS: String = "EXTRA_STATUS"
class adding_food : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_food)

        // ketika activity aktif maka StatusReceiver akan diproses
        var StatusReceiver = MyStatusReceiver()
        var filter = IntentFilter()
        // receiver akan bekerja ketika status Airplane Mode telah berubah
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(StatusReceiver,filter)

        // ketika activity aktif maka SMSReceiver akan diproses
        var SMSReceiver = MySMSReceiver()
        var filter2 = IntentFilter()
        // receiver akan bekerja ketika menerima sebuah SMS
        filter2.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
        registerReceiver(SMSReceiver,filter2)

        // mendeklarasikan id image button dan image view dari adding_food.xml
        val addImg = findViewById<ImageButton>(R.id.camera)
        val viewImg = findViewById<ImageView>(R.id.insertphoto)
        var strURL = "https://www.masakapahariini.com/wp-content/uploads/2019/01/nasi-goreng-jawa-620x440.jpg";

        // memanggil addImg untuk bisa di click
        addImg.setOnClickListener {
            Thread (Runnable {
                // merequest gambar dari link URL
                val bitmap = processBitMap(strURL)
                //update image dilakukan melalui viewImg.post
                viewImg.post {
                    //data gambar diambil dari bitmap
                    viewImg.setImageBitmap(bitmap);
                }
            }).start()
            // pada saat image button diclick Logo dan tulisan akan menjadi invisible
            camera.setVisibility(View.INVISIBLE)
            chooseortakephoto.setVisibility(View.INVISIBLE)
        }

        fragment.setOnClickListener {
            val fragment1 = Intent(this, MainActivityFragment::class.java)
            startActivity(fragment1)
        }

        recevier.setOnClickListener {
            val reciever2 = Intent(this, reciever2::class.java)
            startActivity(reciever2)
        }

        button4.setOnClickListener {
            var Intent2Act = Intent(this,MainActivity2::class.java)
            Intent2Act.putExtra(EXTRA_NAMA,"Adi")
            Intent2Act.putExtra(EXTRA_UMUR,32)
            startActivity(Intent2Act)
        }

        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val chefpage = Intent(this@adding_food,chef_page::class.java)
            startActivity(chefpage)
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@adding_food,homepage::class.java)
            startActivity(homepage)
        }

        update.setOnClickListener {
            editTextTextPersonName10.text = description.text
            description.setText("")

            writeFileInternal()
        }

        read.setOnClickListener {
            restoreData()
        }

        restore.setOnClickListener {
            readFileInternal()
        }

        cleardata.setOnClickListener {
            delData()
        }
    }

    private fun delData() {
        if(fileList().size != 0){
            for (i in fileList() ){
                deleteFile(i)
            }
            description.setText("Deleted")
        }
        else {
            description.setText("Empty File")
        }
    }

    private fun readFileInternal() {
        description.text.clear()
        try {
            var read = openFileInput("FoodData.txt").apply{
                bufferedReader().useLines {
                    for (text in it.toList() ){
                        description.setText("${description.text}\\n$text")
                    }
                }
            }
        }
        //untuk menangkap file yang error
        catch (e : FileNotFoundException){
            Toast.makeText(this,"File Not Found", Toast.LENGTH_SHORT).show()
        }
        catch (e : IOException){
            Toast.makeText(this,"File can't be Read", Toast.LENGTH_SHORT).show()
        }
    }

    private fun restoreData() {
        description.text.clear()
        if(fileList().size != 0){
            for (i in fileList() ){
                description.setText("${description.text}\\n$i")
            }
        }
        else {
            description.setText("Empty File")
        }
    }

    private fun writeFileInternal() {
        //membuat open File dengan nama FoodData bertipe data txt dan dengan mode private
        var output = openFileOutput("FoodData.txt", Context.MODE_PRIVATE).apply {
            //data string yang dituliskan di textbox "description" akan dimasukkan ke dalam file FoodData.txt
            write(description.text.toString().toByteArray())
            //menutup file
            close()
        }
        //menyimpan file dengan nama FoodData.txt
        var filedata = File(this.filesDir, "FoodData.txt")
        //melihat dimana file ini akan disimpan oleh OS android
        Log.w("Ok", filedata.absolutePath)
        //memebersihkan text box "description" dan menampilkan pop up "Saved"
        description.text.clear()
        Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
    }

    // proses request data dari server
    private fun processBitMap(url: String): Bitmap? {
        return try {
            val url = URL(url)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            // gambar didecode berupa data stream
            val myBitmap = BitmapFactory.decodeStream(input)

            // gambar yag sudah didecode akan dikembalikan ke bitmap lama
            myBitmap
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_STATUS, editTextTextPersonName10.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        editTextTextPersonName10.text = savedInstanceState?.getString(EXTRA_STATUS) ?: "Kosong"
    }
}
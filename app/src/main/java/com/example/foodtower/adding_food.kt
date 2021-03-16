package com.example.foodtower

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_adding_food.*
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

        val addImg = findViewById<ImageButton>(R.id.camera)
        val viewImg = findViewById<ImageView>(R.id.insertphoto)
        val strURL = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.masakapahariini.com%2Fresep%2Fresep-nasi-goreng-jawa%2F&psig=AOvVaw1VyVGfB1VoyrJhzhMGJTPt&ust=1615987325823000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJjwkYb0tO8CFQAAAAAdAAAAABAD"

        addImg.setOnClickListener {
            Thread (Runnable {
                val bitmap = processBitMap(strURL)
                viewImg.post {
                    viewImg.setImageBitmap(bitmap);
                }
            }).start()
        }

        private fun processBitMap(url: String): Bitmap? {
            return try {
                val url = URL(url)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                val myBitmap = BitmapFactory.decodeStream(input)

                myBitmap
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
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

        button3.setOnClickListener {
            editTextTextPersonName10.text = editTextTextPostalAddress.text
            editTextTextPostalAddress.setText("")
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
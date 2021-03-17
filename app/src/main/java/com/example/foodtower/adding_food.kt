package com.example.foodtower

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.foodtower.Fragment.FragmentA
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
        var strURL = "https://www.masakapahariini.com/wp-content/uploads/2019/01/nasi-goreng-jawa-620x440.jpg";

        addImg.setOnClickListener {
            Thread (Runnable {
                val bitmap = processBitMap(strURL)
                viewImg.post {
                    viewImg.setImageBitmap(bitmap);
                }
            }).start()
            camera.setVisibility(View.INVISIBLE)
            chooseortakephoto.setVisibility(View.INVISIBLE)
        }

        button4.setOnClickListener {
            var Intent2Act = Intent(this,MainActivity2::class.java)
            Intent2Act.putExtra(EXTRA_NAMA,"Adi")
            Intent2Act.putExtra(EXTRA_UMUR,32)
            startActivity(Intent2Act)
        }

        val fragment = findViewById<Button>(R.id.fragment)
        fragment.setOnClickListener {
            val fragment1 = Intent(this@adding_food,main_fragment::class.java)
            startActivity(fragment1)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_STATUS, editTextTextPersonName10.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        editTextTextPersonName10.text = savedInstanceState?.getString(EXTRA_STATUS) ?: "Kosong"
    }
}
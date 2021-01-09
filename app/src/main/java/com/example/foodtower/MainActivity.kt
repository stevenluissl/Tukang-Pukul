package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        imageButton?.setOnClickListener {
            val homepage = Intent(this@MainActivity,homepage::class.java)
            startActivity(homepage)
        }
    }
}
package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_chefmenu.*
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_main.*

class chefmenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chefmenu)

        subscribe.setOnClickListener {
            val intent = Intent(this,subscribepage::class.java)
            startActivity(intent)
        }
        vote.setOnClickListener {
            val intent = Intent(this,food_menu1::class.java)
            startActivity(intent)
        }
        vote1.setOnClickListener {
            val intent = Intent(this,food_menu2::class.java)
            startActivity(intent)
        }
        vote2.setOnClickListener {
            val intent = Intent(this,food_menu3::class.java)
            startActivity(intent)
        }
        vote3.setOnClickListener {
            val intent = Intent(this,food_menu1::class.java)
            startActivity(intent)
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@chefmenu,homepage::class.java)
            startActivity(homepage)
        }
        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val homepage = Intent(this@chefmenu,homepage::class.java)
            startActivity(homepage)
        }
    }
}
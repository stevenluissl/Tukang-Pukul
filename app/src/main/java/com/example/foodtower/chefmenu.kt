package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chefmenu.*
import kotlinx.android.synthetic.main.activity_homepage.*

class chefmenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chefmenu)

        subscribe.setOnClickListener {
            val intent = Intent(this,subscribepage::class.java)
            startActivity(intent)
        }
    }
}
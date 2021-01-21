package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chef_page.*
import kotlinx.android.synthetic.main.activity_homepage.*

class chef_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef_page)

        buttonchef.setOnClickListener {
            val intent = Intent(this, client_list::class.java)
            startActivity(intent)
        }
    }
}
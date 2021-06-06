package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class navigation_bar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)

        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val homepage = Intent(this@navigation_bar, homepage::class.java)
            startActivity(homepage)
        }

        val chefpagebtside = findViewById<ImageButton>(R.id.chef_page_bt_side)
        chefpagebtside?.setOnClickListener {
            val chefpage = Intent(this@navigation_bar, chef_page::class.java)
            startActivity(chefpage)
        }

        val voteresultbtside = findViewById<ImageButton>(R.id.vote_result_bt_side)
        voteresultbtside?.setOnClickListener {
            val voteresult = Intent(this@navigation_bar, vote_result::class.java)
            startActivity(voteresult)
        }
    }
}
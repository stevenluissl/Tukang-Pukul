package com.example.foodtower

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food_menu1.*

class food_menu1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu1)



        //membentuk intent dan menjalankan service
        var voteService = Intent (this, MyService::class.java)
        button.setOnClickListener {
            startService(voteService)
        }

        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@food_menu1,homepage::class.java)
            startActivity(homepage)
        }
        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val chefmenu = Intent(this@food_menu1,chefmenu::class.java)
            startActivity(chefmenu)
        }

        /*button.setOnClickListener {
            var Intent2Act = Intent(this,MainActivity3::class.java)
            var p = person( "Adi",0,"adi@gmail.com")
            Intent2Act.putExtra(EXTRA_PERSON,p)
            startActivity(Intent2Act)
        }*/
    }
}
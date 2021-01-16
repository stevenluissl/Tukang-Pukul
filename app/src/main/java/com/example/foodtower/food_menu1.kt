package com.example.foodtower

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class food_menu1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu1)

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

    }

    fun getAlertDialog(view: View) {
        var Vote = AlertDialog.Builder(this)
            .setTitle("Vote")
            .setMessage("Apakah Anda ingin Vote?")
            .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Vote Berhasil", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
            })
        Vote.show()
    }
}
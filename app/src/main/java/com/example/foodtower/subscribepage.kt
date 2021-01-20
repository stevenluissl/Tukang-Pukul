package com.example.foodtower

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class subscribepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscribepage)

        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val chefmenu = Intent(this@subscribepage,chefmenu::class.java)
            startActivity(chefmenu)
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@subscribepage,homepage::class.java)
            startActivity(homepage)
        }
    }

    fun getAlertDialog(view: View) {
        var reqinformation = AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Apakah anda ingin Request Information?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Request Berhasil", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"", Toast.LENGTH_SHORT).show()
            })
        reqinformation.show()
    }
}
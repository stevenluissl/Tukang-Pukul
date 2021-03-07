package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_adding_food.*

private const val EXTRA_NAMA = "EXTRA_NAMA"
class adding_food : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_food)

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
        outState.putString(EXTRA_NAMA, editTextTextPersonName10.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        editTextTextPersonName10.text = savedInstanceState?.getString(EXTRA_NAMA) ?: "Kosong"
    }
}
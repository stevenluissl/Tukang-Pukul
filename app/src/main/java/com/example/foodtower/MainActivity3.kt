package com.example.foodtower

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var p = intent.getParcelableExtra<Person>(EXTRA_PERSON)

        textView2.text = "Nama = ${p?.Nama} dengan Umur ${p?.Umur} Email = ${p?.Email}"4
    }
}
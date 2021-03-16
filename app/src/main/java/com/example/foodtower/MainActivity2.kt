        package com.example.foodtower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var name = intent.getStringExtra(EXTRA_NAMA) ?: "No-name"
        var umur = intent.getIntExtra(EXTRA_UMUR,0)

        textView.text = "nama = $name dengan Umur $umur"
    }
}
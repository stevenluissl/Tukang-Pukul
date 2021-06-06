package com.example.foodtower2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var temp = data_userTransaction(this)
        var result = ""
        for (str in temp.viewName()) {
            result += str + System.getProperty("line.separator")
        }
        main_textview1.text = result
    }
}
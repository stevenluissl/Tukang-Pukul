package com.example.foodtower

import android.content.Context

class FirstRun (context: Context){
    private val keyPref = "FIRST_RUN"
    private var mySharedPref = context.getSharedPreferences(
        "SharedPreferFile", Context.MODE_PRIVATE)
    var firstRun : Boolean
    get() = mySharedPref.getBoolean(keyPref,true)
    set(value) {
        mySharedPref.edit().putBoolean(keyPref, value).commit()
    }
}
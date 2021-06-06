package com.example.foodtower

import android.content.Context

class FirstRun (context: Context){
    //key untuk shared preference
    private val keyPref = "FIRST_RUN"
    //membuat shared preference (bersifat private)
    private var mySharedPref = context.getSharedPreferences(
        "SharedPreferFile", Context.MODE_PRIVATE)
    var firstRun : Boolean
    //jika di-run pertama kali akan bernilai true, dan seterusnya
    //akan bernilai value (akan dibuat bernilai false)
    get() = mySharedPref.getBoolean(keyPref,true)
    set(value) {
        mySharedPref.edit().putBoolean(keyPref, value).commit()
    }
}
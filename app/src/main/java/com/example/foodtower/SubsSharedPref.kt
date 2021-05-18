package com.example.foodtower

import android.content.Context
import android.content.SharedPreferences

class SubsSharedPref (context: Context, fileName: String) {
    //deklarasi key
    val name = "nama"
    val phonenumber = "nohp"
    val address = "alamat"
    val city = "kota"
    val district = "kecamatan"

    private var myPreferences : SharedPreferences
    init {
        //membuat shared preferences (bersifat private)
        myPreferences = context.getSharedPreferences(fileName,Context.MODE_PRIVATE)
    }

    //menambahkan fungsi editDataSubs ke dalam fungsi shared preferences
    inline fun SharedPreferences.editDataSubs(operator:(SharedPreferences.Editor)-> Unit){
        val editDataSubs = edit()
        //operator akan menjalankan fungsi edit
        operator(editDataSubs)
        editDataSubs.apply()
    }

    var subsname : String?
        //tampilkan data
        get() = myPreferences.getString(name, "Data tidak tersedia")
        //tambah data atau edit data
        set(value){
            myPreferences.editDataSubs {
                it.putString(name, value)
            }
        }

    var subsphonenumber : String?
        //tampilkan data
        get() = myPreferences.getString(phonenumber, "Data tidak tersedia")
        //tambah data atau edit data
        set(value){
            myPreferences.editDataSubs {
                it.putString(phonenumber, value)
            }
        }

    var subsaddress : String?
        //tampilkan data
        get() = myPreferences.getString(address, "Data tidak tersedia")
        //tambah data atau edit data
        set(value){
            myPreferences.editDataSubs {
                it.putString(address, value)
            }
        }

    var subscity : String?
        //tampilkan data
        get() = myPreferences.getString(city, "Data tidak tersedia")
        //tambah data atau edit data
        set(value){
            myPreferences.editDataSubs {
                it.putString(city, value)
            }
        }

    var subsdistrict : String?
        //tampilkan data
        get() = myPreferences.getString(district, "Data tidak tersedia")
        //tambah data atau edit data
        set(value){
            myPreferences.editDataSubs {
                it.putString(district, value)
            }
        }
}
package com.example.foodtower

import MyDatabase.UserDataBase
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context) : SQLiteOpenHelper (
    // 4 data yang dibutuhkan oleh SQLiteOpenHelper
    context, DATABASE_NAME, null, DATABASE_VERSION)
{
    companion object {
        // nama dari file database
        private val DATABASE_NAME = "SQLiteDatabase.db"
        // versi dari database
        private val DATABASE_VERSION = 1
    }

    // digunakan pertama kali saat memanggil database
    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_USER_TABLE = "CREATE TABLE ${UserDataBase.UserTable.USER_TABLE}" +
                "{$"
    }

    // digunakan ketika verseion dari database berubah
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
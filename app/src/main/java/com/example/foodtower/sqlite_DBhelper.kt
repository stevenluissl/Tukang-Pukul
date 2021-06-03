package com.example.foodtower

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class sqlite_DBhelper (context: Context) : SQLiteOpenHelper (
    context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DATABASE_NAME = "SQLite_database.db"
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_USER_TABLE = "CREATE TABLE ${sqlite_userDB.userTable.USER_TABLE}" +
                "{${sqlite_userDB.userTable.COLUMN_ID} INTEGER PRIMARY KEY," +
                "{${sqlite_userDB.userTable.COLUMN_NAME} TEXT" +
                "{${sqlite_userDB.userTable.COLUMN_HP} TEXT" +
                "{${sqlite_userDB.userTable.COLUMN_LOCATION} TEXT" +
                "{${sqlite_userDB.userTable.COLUMN_REKENING} TEXT" +
                "{${sqlite_userDB.userTable.COLUMN_PRICE} TEXT)"
        db?.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${sqlite_userDB.userTable.USER_TABLE}")
        onCreate(db)
    }

    fun addUser(sqliteUser: sqlite_user): Long {
        var db = this.writableDatabase
        var contentValues = ContentValues().apply {
            put(sqlite_userDB.userTable.COLUMN_NAME, sqliteUser.nama)
            put(sqlite_userDB.userTable.COLUMN_NAME, sqliteUser.no_telp)
            put(sqlite_userDB.userTable.COLUMN_NAME, sqliteUser.lokasi)
            put(sqlite_userDB.userTable.COLUMN_NAME, sqliteUser.rekening)
            put(sqlite_userDB.userTable.COLUMN_NAME, sqliteUser.harga)
        }
        var success = db.insert(sqlite_userDB.userTable.USER_TABLE, null, contentValues)
        db.close()
        return success
    }

    fun viewAllName() : List<String> {
        val nameList = ArrayList<String>()
        val SELECT_NAME = "SELECT ${sqlite_userDB.userTable.COLUMN_NAME} FROM " +
                "${sqlite_userDB.userTable.USER_TABLE}"
        var db = this.readableDatabase
        var cursor : Cursor ?= null
        try {
            cursor = db.rawQuery(SELECT_NAME, null)
        }
        catch (e : SQLException) {
            return ArrayList()
        }
        var userName = ""
        if (cursor.moveToFirst()) {
            do {
                userName = cursor.getString(cursor.getColumnIndex(sqlite_userDB.userTable.COLUMN_NAME))
                nameList.add(userName)
            }
            while (cursor.moveToNext())
        }
        return nameList
    }

    fun deleteUser(nama : String) {
        var db = this.writableDatabase
        var selection = "${sqlite_userDB.userTable.COLUMN_NAME} = ?"
        var selectionAgrs = arrayOf(nama)
        db.delete(sqlite_userDB.userTable.USER_TABLE, selection, selectionAgrs)
    }
}
package com.example.foodtower

import MyDatabase.sqlite_userDB
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class sqlite_DBhelper (context: Context) : SQLiteOpenHelper (
    context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DATABASE_NAME = "SQLitedb.db"
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_USER_TABLE = "CREATE TABLE ${sqlite_userDB.userTable.USER_TABLE} " +
                "(${sqlite_userDB.userTable.COLUMN_ID} INTEGER PRIMARY KEY," +
                "${sqlite_userDB.userTable.COLUMN_NAME} TEXT," +
                "${sqlite_userDB.userTable.COLUMN_HP} TEXT," +
                "${sqlite_userDB.userTable.COLUMN_LOCATION} TEXT," +
                "${sqlite_userDB.userTable.COLUMN_REKENING} TEXT," +
                "${sqlite_userDB.userTable.COLUMN_PRICE} TEXT)"
        db?.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${sqlite_userDB.userTable.USER_TABLE}")
        onCreate(db)
    }

    fun addUser(sqliteUser: sqlite_user): Long {
        var db = this.writableDatabase
        var contentValues = ContentValues().apply {
            put(sqlite_userDB.userTable.COLUMN_NAME, sqliteUser.nama)
            put(sqlite_userDB.userTable.COLUMN_HP, sqliteUser.no_telp)
            put(sqlite_userDB.userTable.COLUMN_LOCATION, sqliteUser.lokasi)
            put(sqlite_userDB.userTable.COLUMN_REKENING, sqliteUser.rekening)
            put(sqlite_userDB.userTable.COLUMN_PRICE, sqliteUser.harga)
        }
        var success = db.insert(sqlite_userDB.userTable.USER_TABLE, null, contentValues)
        db.close()
        return success
    }

    fun viewAllName(): List<String> {
        val nameList = ArrayList<String>()
        val SELECT_NAME = "SELECT ${sqlite_userDB.userTable.COLUMN_NAME} FROM " +
                "${sqlite_userDB.userTable.USER_TABLE}"
        var db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(SELECT_NAME, null)
        } catch (e: SQLException) {
            return ArrayList()
        }
        var userName = ""
        if (cursor.moveToFirst()) {
            do {
                userName =
                    cursor.getString(cursor.getColumnIndex(sqlite_userDB.userTable.COLUMN_NAME))
                nameList.add(userName)
            } while (cursor.moveToNext())
        }
        return nameList
    }

    fun deleteUser(nama: String) {
        var db = this.writableDatabase
        var selection = "${sqlite_userDB.userTable.COLUMN_NAME} = ?"
        var selectionArgs = arrayOf(nama)
        db.delete(sqlite_userDB.userTable.USER_TABLE, selection, selectionArgs)
    }

    fun deleteAll() {
        var db = this.writableDatabase
        db.delete(sqlite_userDB.userTable.USER_TABLE, null, null)
    }

    fun begintrans() {
        this.writableDatabase.beginTransaction()
    }

    fun successtrans() {
        this.writableDatabase.setTransactionSuccessful()
    }

    fun endusertrans() {
        this.writableDatabase.endTransaction()
    }

    fun addusertrans(sqliteuser: sqlite_user) {
        var sqlString = "INSERT ${sqlite_userDB.userTable.USER_TABLE}" +
                "(${sqlite_userDB.userTable.COLUMN_ID}," +
                "${sqlite_userDB.userTable.COLUMN_NAME}," +
                "${sqlite_userDB.userTable.COLUMN_HP}," +
                "${sqlite_userDB.userTable.COLUMN_LOCATION}," +
                "${sqlite_userDB.userTable.COLUMN_REKENING}," +
                "${sqlite_userDB.userTable.COLUMN_PRICE}) VALUES (?,?,?,?,?,?)"
        val statment = this.writableDatabase.compileStatement(sqlString)
        statment.bindLong(1, sqliteuser.id.toLong())
        statment.bindString(2, sqliteuser.nama)
        statment.bindString(3, sqliteuser.no_telp)
        statment.bindString(4, sqliteuser.lokasi)
        statment.bindString(5, sqliteuser.rekening)
        statment.bindString(5, sqliteuser.harga)
        statment.execute()
        statment.clearBindings()
    }
}
package com.example.foodtower2

import MyDatabase.sqlite_userDB.userTable.Companion.COLUMN_HP
import MyDatabase.sqlite_userDB.userTable.Companion.COLUMN_ID
import MyDatabase.sqlite_userDB.userTable.Companion.COLUMN_LOCATION
import MyDatabase.sqlite_userDB.userTable.Companion.COLUMN_NAME
import MyDatabase.sqlite_userDB.userTable.Companion.COLUMN_PRICE
import MyDatabase.sqlite_userDB.userTable.Companion.COLUMN_REKENING
import android.content.Context

class data_userTransaction (context: Context) {
    private val myContentResolver = context.contentResolver

    fun viewName() : List<String> {
        var ListName = ArrayList<String>()
        var mProjection = arrayOf(COLUMN_ID, COLUMN_NAME, COLUMN_HP, COLUMN_LOCATION,
            COLUMN_REKENING, COLUMN_PRICE)
        var cursor = myContentResolver.query(
            ContentProviderUri.CONTENT_URI, mProjection, null, null, null)
        if (cursor != null) {
            var userName = ""
            if (cursor.moveToFirst()) {
                do {
                    userName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                } while (cursor.moveToNext())
                ListName.add(userName)
            }
        }
        return ListName
    }
}
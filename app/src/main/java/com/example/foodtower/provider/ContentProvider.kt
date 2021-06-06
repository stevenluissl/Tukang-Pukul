package com.example.foodtower.provider

import MyDatabase.sqlite_userDB
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import com.example.foodtower.sqlite_DBhelper

class ContentProvider : ContentProvider () {
    private var dbHelper : sqlite_DBhelper ?= null

    override fun onCreate(): Boolean {
        dbHelper = sqlite_DBhelper(context!!)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?,
    ): Cursor? {
        var BuildQuery = SQLiteQueryBuilder()
        BuildQuery.tables = sqlite_userDB.userTable.USER_TABLE
        var cursor : Cursor = BuildQuery.query(dbHelper?.readableDatabase,
        projection, selection, selectionArgs, null, null, sortOrder)

        cursor.setNotificationUri(context?.contentResolver, uri)
        return cursor
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?,
    ): Int {
        TODO("Not yet implemented")
    }

    companion object {
        val AUTHORITY = "com.example.foodtower.provider.provider.ContentProvider"
        val TABLEUSER = sqlite_userDB.userTable.USER_TABLE
        val CONTENT_URI = Uri.parse("content://$AUTHORITY/$TABLEUSER")
    }
}
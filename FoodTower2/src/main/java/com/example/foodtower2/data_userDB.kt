package com.example.foodtower2

import MyDatabase.sqlite_userDB
import android.net.Uri
import android.provider.BaseColumns

object data_userDB {
    class userTable : BaseColumns {
        companion object {
            val USER_TABLE = "user_table"
            val COLUMN_ID = "user_id"
            val COLUMN_NAME = "user_name"
            val COLUMN_HP = "user_hp"
            val COLUMN_LOCATION = "user_location"
            val COLUMN_REKENING = "user_rekening"
            val COLUMN_PRICE = "user_price"
        }
    }
}

class ContentProviderUri {
    companion object {
        val AUTHORITY = "com.example.foodtower.provider.provider.ContentProvider"
        val TABLEUSER = sqlite_userDB.userTable.USER_TABLE
        val CONTENT_URI = Uri.parse("content://$AUTHORITY/$TABLEUSER")
    }
}
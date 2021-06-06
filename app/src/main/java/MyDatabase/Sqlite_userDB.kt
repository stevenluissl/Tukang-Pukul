package MyDatabase

import android.provider.BaseColumns

object sqlite_userDB {
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

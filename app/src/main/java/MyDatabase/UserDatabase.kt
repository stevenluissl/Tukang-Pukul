package MyDatabase

import android.provider.BaseColumns

object UserDataBase {
    // interface yang akan mengimplementasikan BaseColumn
    class UserTable : BaseColumns {
        companion object {
            val USER_TABLE = "Table_User"
            val COLUMN_ID ="User_ID"
            val COLUMN_Name ="User_Name"
            val COLUMN_HP ="User_HP"
            val COLUMN_Address ="User_Address"
            val COLUMN_City ="User_City"
            val COLUMN_District ="User_District"
        }
    }
}
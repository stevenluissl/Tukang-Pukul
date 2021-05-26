package com.example.foodtower

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class userSubs(
    @PrimaryKey var id : Int,
    @ColumnInfo(name = "COLUMN_NAME") var nama : String = "",
    @ColumnInfo(name = "COLUMN_PHONENUMBER") var NoHP : String = "",
    @ColumnInfo(name = "COLUMN_ADDRESS") var alamat : String = "",
    @ColumnInfo(name = "COLUMN_CITY") var kota : String = "",
    @ColumnInfo(name = "COLUMN_DISTRICT") var kecamatan : String = ""
)
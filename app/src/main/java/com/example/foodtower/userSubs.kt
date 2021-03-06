package com.example.foodtower

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Table intity yang akan dibuat di database
@Entity
data class userSubs(
    // Deklasrasi kolom
    @PrimaryKey var id : Int,
    @ColumnInfo(name = "COLUMN_NAME") var nama : String = "",
    @ColumnInfo(name = "COLUMN_PHONENUMBER") var NoHP : String = "",
    @ColumnInfo(name = "COLUMN_LOCATION") var lokasi : String = "",
    @ColumnInfo(name = "COLUMN_BANKACCNUMBER") var bank : String = "",
    @ColumnInfo(name = "COLUMN_PRICE") var harga : String = ""
)
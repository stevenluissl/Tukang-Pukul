package com.example.foodtower

import androidx.room.*

@Dao
interface userSubsDAO {
    @Query("Select * from userSubs")
    fun getAllDataSubs() : List<userSubs>

    @Insert
    fun InsertDataSubs(vararg user : userSubs)

    @Query("Update userSubs set COLUMN_NAME = :nama, COLUMN_PHONENUMBER = :NoHP, COLUMN_LOCATION = :lokasi, COLUMN_PRICE = :harga where COLUMN_BANKACCNUMBER = :bank")
    fun UpdateDataSubs(nama : String, NoHP : String, lokasi : String, harga : String, bank : String)

    @Query("Delete from userSubs where COLUMN_NAME = :nama")
    fun DeleteDataSubs(nama : String)
}
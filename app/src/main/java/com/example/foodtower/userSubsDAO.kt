package com.example.foodtower

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Menuliskan query ke dalam database
@Dao
interface userSubsDAO {
    // Query select
    @Query("Select * from userSubs")
    fun getAllDataSubs() : List<userSubs>

    // Menginput data kedalam array yang tidak diketahui ukurannya
    @Insert
    fun InsertDataSubs(vararg user : userSubs)

    // Mengupdate seluruh kolom data yang ada di sebuah row berdasarkan data yang ada di kolom Bank Account
    @Query("Update userSubs set COLUMN_NAME = :nama, COLUMN_PHONENUMBER = :NoHP, COLUMN_LOCATION = :lokasi, COLUMN_PRICE = :harga  where COLUMN_BANKACCNUMBER = :bank")
    fun UpdateDataSubs(nama : String, NoHP : String, lokasi : String, harga : String, bank : String)

    // Menghapus seluruh row berdasarkan data yang ada di kolom nama
    @Query("Delete from userSubs where COLUMN_NAME = :nama")
    fun DeleteDataSubs(nama : String)
}
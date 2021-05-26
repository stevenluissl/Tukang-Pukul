package com.example.foodtower

import androidx.room.*

@Dao
interface userSubsDAO {
    @Query("Select * from userSubs")
    fun getAllDataSubs() : List<userSubs>

    @Insert
    fun InsertDataSubs(vararg user : userSubs)

    @Update
    fun UpdateDataSubs(vararg user : userSubs)

    @Delete
    fun DeleteDataSubs(vararg user : userSubs)
}
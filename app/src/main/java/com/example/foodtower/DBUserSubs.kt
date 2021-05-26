package com.example.foodtower

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(userSubs::class), version = 1)
abstract class DBUserSubs : RoomDatabase() {
    abstract fun userDAO() : userSubsDAO
}
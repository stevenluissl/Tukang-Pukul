package com.example.foodtower

import androidx.room.Database
import androidx.room.RoomDatabase

// Database dari tabel userSubs
@Database(entities = arrayOf(userSubs::class), version = 1)
abstract class DBUserSubs : RoomDatabase() {
    // Mengimplementasi userDAO
    abstract fun userDAO() : userSubsDAO
}
package com.example.bitfit1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WaterEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun waterDao(): WaterDao
}

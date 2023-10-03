package com.example.bitfit1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WaterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWaterEntry(entry: WaterEntry): Long

    @Query("SELECT * FROM water_entries ORDER BY date DESC")
    fun getAllWaterEntries(): LiveData<List<WaterEntry>>
}


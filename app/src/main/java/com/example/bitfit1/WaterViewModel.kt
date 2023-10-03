package com.example.bitfit1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class WaterViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    private val waterDao = db.waterDao()

    val allWaterEntries: LiveData<List<WaterEntry>> = waterDao.getAllWaterEntries()

    fun insertWaterEntry(entry: WaterEntry) {
        viewModelScope.launch {
            waterDao.insertWaterEntry(entry)
        }
    }
}


package com.example.bitfit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WaterEntryAdapter
    private val viewModel by viewModels<WaterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = WaterEntryAdapter(emptyList())
        val recyclerView: RecyclerView = findViewById(R.id.waterEntriesRecyclerView)
        recyclerView.adapter = adapter

        viewModel.allWaterEntries.observe(this, Observer { entries ->
            adapter.updateEntries(entries)
        })

        val addButton: Button = findViewById(R.id.addEntryButton)
        addButton.setOnClickListener {
            val amountEditText: EditText = findViewById(R.id.waterAmountEditText)
            val amount = amountEditText.text.toString().toIntOrNull() ?: return@setOnClickListener
            val entry = WaterEntry(date = getCurrentDate(), amount = amount)

            // Using coroutine to insert the data
            lifecycleScope.launch {
                viewModel.insertWaterEntry(entry)
            }
        }
    }

    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return sdf.format(Date())
    }
}


package com.example.bitfit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WaterEntryAdapter(private var entries: List<WaterEntry>) : RecyclerView.Adapter<WaterEntryAdapter.WaterViewHolder>() {

    inner class WaterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_water_entry, parent, false)
        return WaterViewHolder(view)
    }

    override fun onBindViewHolder(holder: WaterViewHolder, position: Int) {
        val entry = entries[position]
        holder.dateTextView.text = entry.date
        holder.amountTextView.text = "${entry.amount}ml"
    }

    override fun getItemCount(): Int = entries.size

    fun updateEntries(newEntries: List<WaterEntry>) {
        this.entries = newEntries
        notifyDataSetChanged()
    }
}

/*package com.example.nir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ButtonAdapter(private val buttons: List<String>, private val listener: (String) -> Unit) :
    RecyclerView.Adapter<ButtonAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btn_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_place_page, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val button = buttons[position]
        holder.button.text = button
        holder.button.setOnClickListener { listener(button) }
    }

    override fun getItemCount() = buttons.size
}*/
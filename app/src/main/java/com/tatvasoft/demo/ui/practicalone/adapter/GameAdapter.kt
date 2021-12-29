package com.tatvasoft.demo.ui.practicalone.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameHolder>() {
    class GameHolder(view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {

    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    }

    fun addData(dataCount: Int) {
        notifyDataSetChanged()
    }
}
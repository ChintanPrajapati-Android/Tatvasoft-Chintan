package com.tatvasoft.demo.ui.practicalone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatvasoft.demo.R
import com.tatvasoft.demo.model.GameDataModel

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameHolder>() {
    private val alData = ArrayList<GameDataModel>()
    class GameHolder(view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(LayoutInflater.from(parent.context).inflate(R.layout.lay_game_item, parent, false))
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return alData.size
    }

    fun addData(dataCount: Int) {
        alData.clear()
        for (i in 0 until dataCount){
            alData.add(GameDataModel(index = i))
        }
        notifyDataSetChanged()
    }
}
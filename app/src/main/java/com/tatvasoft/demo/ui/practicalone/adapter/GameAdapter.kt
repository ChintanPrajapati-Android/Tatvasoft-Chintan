package com.tatvasoft.demo.ui.practicalone.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatvasoft.demo.R
import com.tatvasoft.demo.model.GameDataModel
import kotlinx.android.synthetic.main.lay_game_item.view.*

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameHolder>() {
    private var highLightValue: Int = -1
    private val alData = ArrayList<GameDataModel>()
    private val alSavePosition = ArrayList<Int>()

    var onItemClick: ((position: Int) -> Unit)? = null
    var onDone: (() -> Unit)? = null

    class GameHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.lay_game_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        val item = alData[position]
        if (highLightValue == item.index) {
            holder.itemView.containerColor.setOnClickListener {
                alSavePosition.remove(item.index)
                item.isDone = true
                onItemClick?.invoke(position)
                notifyItemChanged(position)
                if (alSavePosition.isEmpty()){
                    onDone?.invoke()
                }
            }
        }else{
            holder.itemView.containerColor.setOnClickListener(null)
        }

        if (highLightValue == item.index) {
            holder.itemView.containerColor.setCardBackgroundColor(Color.RED)
        }

        if (item.isDone) {
            holder.itemView.containerColor.setOnClickListener(null)
            holder.itemView.containerColor.setCardBackgroundColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int {
        return alData.size
    }

    fun addData(dataCount: Int) {
        alData.clear()
        alSavePosition.clear()
        for (i in 0 until dataCount) {
            alData.add(GameDataModel(index = i))
            alSavePosition.add(i)
        }
        notifyDataSetChanged()
    }

    fun randomFunction() {
        if (alSavePosition.isNotEmpty()) {
            highLightValue = alSavePosition.random()
            notifyItemChanged(highLightValue)
        }else {
            highLightValue = -1
            notifyItemChanged(highLightValue)
        }
    }
}
package com.tatvasoft.demo.ui.practicaltwo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatvasoft.demo.R
import com.tatvasoft.demo.model.Data

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataHolder>() {
    private var alData =  ArrayList<Data>()

    class DataHolder(view : View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.lay_data_item, parent, false))

    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return  0
    }

    fun addData(list : ArrayList<Data>){

    }
}
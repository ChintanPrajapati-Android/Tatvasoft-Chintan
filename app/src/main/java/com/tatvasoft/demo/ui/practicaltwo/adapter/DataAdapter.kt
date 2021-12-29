package com.tatvasoft.demo.ui.practicaltwo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tatvasoft.demo.R
import com.tatvasoft.demo.model.Data
import kotlinx.android.synthetic.main.lay_data_item.view.*

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataHolder>() {
    private var alData = ArrayList<Data>()

    class DataHolder(view: View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.lay_data_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val item = alData[position]
        holder.itemView.tvName.text = item.firstName.plus(" ").plus(item.lastName)
        holder.itemView.tvEmail.text = item.email
        Glide.with(holder.itemView.context)
            .load(item.avatar)
            .circleCrop()
            .into(holder.itemView.ivPic)
    }

    override fun getItemCount(): Int {
        return alData.size
    }

    fun addData(list: ArrayList<Data>) {
        alData = list
        notifyDataSetChanged()
    }
}
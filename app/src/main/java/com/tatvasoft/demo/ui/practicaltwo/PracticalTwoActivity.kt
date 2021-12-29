package com.tatvasoft.demo.ui.practicaltwo

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tatvasoft.demo.R
import com.tatvasoft.demo.base.BaseActivity
import com.tatvasoft.demo.base.Result
import com.tatvasoft.demo.ui.practicaltwo.adapter.DataAdapter
import com.tatvasoft.demo.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.activity_practical_two.*

class PracticalTwoActivity : BaseActivity(R.layout.activity_practical_two) {

    private lateinit var dataViewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adData = DataAdapter()
        rvData.adapter = adData
        rvData.layoutManager = LinearLayoutManager(this)

        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.getData()

        dataViewModel.mData.observe(this, {
            when (it) {
                is Result.Success -> {
                    adData.addData(it.data)

                }
                is Result.Error -> {

                }
            }
        })
    }
}
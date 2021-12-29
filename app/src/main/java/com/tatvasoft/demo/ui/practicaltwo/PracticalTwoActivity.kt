package com.tatvasoft.demo.ui.practicaltwo

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatvasoft.demo.R
import com.tatvasoft.demo.base.BaseActivity
import com.tatvasoft.demo.base.Result
import com.tatvasoft.demo.ui.practicaltwo.adapter.DataAdapter
import com.tatvasoft.demo.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.activity_practical_two.*

class PracticalTwoActivity : BaseActivity(R.layout.activity_practical_two) {

    private lateinit var dataViewModel: DataViewModel
    var loading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adData = DataAdapter()
        rvData.adapter = adData
        rvData.layoutManager = LinearLayoutManager(this)

        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]

        rvData.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleCount = (rvData.layoutManager as LinearLayoutManager).childCount
                    val totalCount = (rvData.layoutManager as LinearLayoutManager).itemCount
                    val pastVisibleItems =
                        (rvData.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (loading) {
                        if ((visibleCount + pastVisibleItems) >= totalCount) {
                            loading = false
                            dataViewModel.getData().apply {
                                pbLoading.visibility = View.VISIBLE
                            }
                        }
                    }
                }

            }
        })

        dataViewModel.getData().apply {
            pbLoading.visibility = View.VISIBLE
        }

        dataViewModel.mData.observe(this, {
            pbLoading.visibility = View.GONE
            when (it) {
                is Result.Success -> {
                    loading = true;
                    adData.addData(it.data.data)

                }
                is Result.Error -> {
                    //If you to set error depends on your requirement
                    makeToast("Something went wrong.!!")
                }
            }
        })
    }
}
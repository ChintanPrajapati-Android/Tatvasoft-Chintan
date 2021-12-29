package com.tatvasoft.demo.ui.practicalone

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tatvasoft.demo.R
import com.tatvasoft.demo.base.BaseActivity
import com.tatvasoft.demo.ui.practicalone.adapter.GameAdapter
import kotlinx.android.synthetic.main.activity_practical_one.*
import kotlin.math.sqrt

class PracticalOneActivity : BaseActivity(R.layout.activity_practical_one) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adGame = GameAdapter()
        rvGame.adapter = adGame

        btnSubmit.setOnClickListener {
            edtInput.text?.let {
                val value = sqrt(edtInput.text.toString().toDouble())
                if (value.isNaN().not()) {
                    rvGame.layoutManager = GridLayoutManager(this, value.toInt())
                    val dataCount =  value.toInt() * value.toInt()
                    adGame.addData(dataCount)
                }
            }
        }
    }
}
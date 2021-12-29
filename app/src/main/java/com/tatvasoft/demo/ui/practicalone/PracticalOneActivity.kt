package com.tatvasoft.demo.ui.practicalone

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.GridLayoutManager
import com.tatvasoft.demo.R
import com.tatvasoft.demo.base.BaseActivity
import com.tatvasoft.demo.ui.practicalone.adapter.GameAdapter
import kotlinx.android.synthetic.main.activity_practical_one.*
import kotlin.math.floor
import kotlin.math.sqrt

class PracticalOneActivity : BaseActivity(R.layout.activity_practical_one) {
    private lateinit var adGame : GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adGame = GameAdapter()
        rvGame.adapter = adGame

        btnSubmit.setOnClickListener {
            edtInput.text?.let {
                val value = sqrt(edtInput.text.toString().toDouble())
                if (value.isNaN().not() && value.isInfinite().not()) {
                    val finalValue =   value - floor(value)
                    if (finalValue == 0.0) {
                        rvGame.layoutManager = GridLayoutManager(this, value.toInt())
                        val dataCount = value.toInt() * value.toInt()
                        adGame.addData(dataCount)
                        callRandomNumber()
                    }else {
                        makeToast(getString(R.string.error_square_root))
                    }
                }
            }
        }

        adGame.onItemClick = {
            callRandomNumber()
        }
    }

    private fun callRandomNumber(){
        Handler(Looper.getMainLooper()).postDelayed({
            adGame.randomFunction()
        },3000)
    }
}
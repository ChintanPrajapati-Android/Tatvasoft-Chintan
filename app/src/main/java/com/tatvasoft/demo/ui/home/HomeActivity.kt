package com.tatvasoft.demo.ui.home

import android.content.Intent
import android.os.Bundle
import com.tatvasoft.demo.R
import com.tatvasoft.demo.base.BaseActivity
import com.tatvasoft.demo.ui.practicalone.PracticalOneActivity
import com.tatvasoft.demo.ui.practicaltwo.PracticalTwoActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnPracticalOne.setOnClickListener {
            startActivity(Intent(this, PracticalOneActivity::class.java))
        }

        btnPracticalTwo.setOnClickListener {
            startActivity(Intent(this, PracticalTwoActivity::class.java))
        }
    }

}
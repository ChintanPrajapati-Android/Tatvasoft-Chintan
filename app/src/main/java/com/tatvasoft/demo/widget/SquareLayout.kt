package com.tatvasoft.demo.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class SquareLayout(context : Context,attrs : AttributeSet ) : RelativeLayout(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
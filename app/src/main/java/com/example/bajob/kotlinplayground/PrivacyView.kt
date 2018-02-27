package com.example.bajob.kotlinplayground

import android.content.Context
import android.content.res.TypedArray
import android.support.v4.content.res.TypedArrayUtils.getResourceId
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * Created by bajob on 2/27/2018.
 */
class PrivacyView @JvmOverloads constructor(context: Context, attrSet: AttributeSet? = null, defStyleAttr: Int = 0) : RelativeLayout(context, attrSet, defStyleAttr) {
    val imageView: ImageView
    val textView1: TextView
    val textView2: TextView
    init {
        val typedArray = attrSet?.let { context.obtainStyledAttributes(it,R.styleable.privacy_view_custom_attributes,0,0) }
        val lp =typedArray!!.getDimension(R.styleable.privacy_view_custom_attributes_privacy_view_custom_padding_left,0.0f)
        val background = typedArray!!.
                getColor(R.styleable.privacy_view_custom_attributes_privacy_view_custom_background,0)
        View.inflate(context,R.layout.privace_policy_layot,this)
        this.setBackgroundColor(background)
        this.setPadding(lp.toInt(),0,0,0)
        imageView = findViewById(R.id.imageView)
        textView1 = findViewById(R.id.text)
        textView2 = findViewById(R.id.text2)
    }
}
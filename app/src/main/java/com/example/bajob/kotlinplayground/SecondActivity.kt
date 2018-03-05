package com.example.bajob.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val secondPojo = intent.getParcelableExtra<SecondPojo>("parcelable")
        button.setOnClickListener {
            toast("${secondPojo.firstPojo.name} father is ${secondPojo.fatherName} and is tool ${secondPojo.firstPojo.height}cm and date is ${secondPojo.date}")
            finish()
        }
    }
}

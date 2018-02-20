package com.example.bajob.kotlinplayground

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val text: TextView by lazy { findViewById<TextView>(R.id.textView) }
    private val button: Button by lazy { findViewById<Button>(R.id.button) }
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = Model("savo", 20)
        val model1 = Model()

        button.setOnClickListener {
            with(text) {
                if (++counter % 2 > 0) {
                    updateText(model, Color.GREEN)
                } else {
                    updateText(model1, Color.BLUE)
                }
                toast(text)
            }
        }

    }

    /*private fun whenTest(cont: Int, model: Model): Unit {
        text.text = model.name
        when {
            cont > 0 -> text.setBackgroundColor(Color.GREEN)
            cont <= 0 -> text.setBackgroundColor(Color.BLUE)
        }
    }*/

    private fun TextView.updateText(model: Model, color: Int) {
        setBackgroundColor(Color.BLUE)
        text = model.name
    }

    fun Context.toast(message: CharSequence, lenght: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, lenght).show()
    }

    data class Model(var name: String = "sasa", var age: Int = 0)
}

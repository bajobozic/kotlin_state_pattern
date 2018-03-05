package com.example.bajob.kotlinplayground

import RetrofitClient
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import kotlinx.android.parcel.Parcelize
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    private val webView by lazy { findViewById<WebView>(R.id.web_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val somethingFromServer = RetrofitClient.apiEndpoints.getSomethingFromServer();
        somethingFromServer.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                val str = response?.body()?.string()
                webView.loadData(str, "text/html", "UTF-8")
                val firstObject = FirstPojo(120.0f,"savo",25)
                val objectToSend = SecondPojo(firstObject,"nebojsa", Date())
                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("parcelable",objectToSend)
                startActivity(intent)
            }
        })
    }
}



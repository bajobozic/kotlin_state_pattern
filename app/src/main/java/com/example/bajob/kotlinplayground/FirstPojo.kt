package com.example.bajob.kotlinplayground

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by bajob on 3/5/2018.
 */
@Parcelize
data class FirstPojo(override val height: Float,val name: String, val age: Int, val array: List<String> = emptyList<String>()) : Parcelable, JustInt {
    override fun justForTest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface JustInt {
    val height:Float
    fun justForTest()
}

package com.example.bajob.kotlinplayground

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by bajob on 3/5/2018.
 */
@Parcelize
data class SecondPojo(val firstPojo: FirstPojo,val fatherName:String,val date: Date):Parcelable
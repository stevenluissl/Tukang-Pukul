package com.example.foodtower

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class person(var nama : String = "No-Name",
                  var Umur : Int =0,
                  var Email : String = "Kosong") : Parcelable{
}
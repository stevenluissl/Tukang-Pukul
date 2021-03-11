package com.example.foodtower

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class person (var Nama : String = "No-name",
                   var Umur : Int = 0,
                   var Email : String = "Kosong") : Parcelable {
}
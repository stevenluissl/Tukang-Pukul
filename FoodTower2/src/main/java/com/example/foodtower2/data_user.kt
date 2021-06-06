package com.example.foodtower2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class data_user (
                 var id :Int = 0,
                 var nama : String = "",
                 var no_telp : String = "",
                 var lokasi : String = "",
                 var rekening : String = "",
                 var harga : String = ""): Parcelable {
}
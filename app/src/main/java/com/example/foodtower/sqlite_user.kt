package com.example.foodtower

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class sqlite_user : Parcelable {
    var id :Int = 0
    var nama : String = ""
    var no_telp : String = ""
    var lokasi : String = ""
    var rekening : String = ""
    var harga : String = ""
}
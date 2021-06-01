package com.example.foodtower

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Data yang ada di USER_TABLE

@Parcelize
// parcelize untuk menyimpan data pada class
// dan akan dikirimkan melalui extra setelah data dibaca
class User : Parcelable {
    var subs_id : Int = 0
    var subs_nama : String = ""
    var subs_nohp : String = ""
    var subs_alamat : String = ""
    var subs_kota : String = ""
    var subs_kecamatan : String = ""
}
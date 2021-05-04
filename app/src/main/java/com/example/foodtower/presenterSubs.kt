package com.example.foodtower

class presenterSubs (setView : interfaceSubs) {
    private  var view = setView
    private  var data = dataSubs()

    //membuat data string
    fun hargaa (nama : String, hargaaa : String) =  when(nama){
        //jika text box berisi Budi, maka text view akan memunculkan harga 2.500.000 per bulan
        "Budi" -> "Price : IDR 2.500.000 / Month"
        //jika text box berisi Asep, maka text view akan memunculkan harga 2.000.000 per bulan
        "Asep" -> "Price : IDR 2.000.000 / Month"
        //jika text box berisi Udin, maka text view akan memunculkan harga 2.500.000 per bulan
        "Udin" -> "Price : IDR 1.500.000 / Month"
        //jika text box berisi nama lainnya, maka text view akan memunculkan harga 2.500.000 per bulan
        else -> "Price : IDR 1.000.000 / Month"
    }

    fun hitungharga(nama : String, hargaaa : String) {
        var harga = hargaa(nama, hargaaa)

        //mengambil data dari function hargaa ke dalam Model
        data.nominal =  harga
        //menampilkan data ke dalam view
        view.tampilharga(data)
    }
}
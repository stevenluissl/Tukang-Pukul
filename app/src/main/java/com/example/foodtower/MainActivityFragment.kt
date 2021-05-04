package com.example.foodtower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodtower.Fragment.FragmentA
import com.example.foodtower.Fragment.FragmentB

//main activity untuk menampung fragmentA dan fargmentB berkomunikasi satu sama lain mengirim data

//menambahkan dan mengimplementasikan member dari InterfaceData
// yang akan menambahkan satu function KirimData dengan parameter editText
class MainActivityFragment : AppCompatActivity(), InterfaceData {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        // membuat sebuah variabel untuk menampung FragmentA
        val fragmentA = FragmentA()
        //support manager untuk menentukan transaksi pertama yang berada pada FragmentA
        supportFragmentManager
            .beginTransaction().replace(R.id.FragmentContainer, fragmentA).commit()
    }



    override fun KirimData(editText: String) {
        //menambahkan/mengimplementasikan Bundle
        val bundle = Bundle()
        bundle.putString("Pesan", editText)

        //function KirimData akan dipanggil dari FragmentA ke FragmentB maka akan terjadi penimpahan
        val transaksi = this.supportFragmentManager.beginTransaction()

        //menginisialisasikan FragmentB
        val fragmentB = FragmentB()
        //memberikan arguments yang berasal dari Bundle untuk komunikasi antar data
        fragmentB.arguments = bundle
        //transaksi yang akan membuat FragmentA akan ditimpa dengan FragmentB
        transaksi.replace(R.id.FragmentContainer, fragmentB)
        //menambahkan transaksi untuk mencegah force close ketika menekan tombol back
        //pada saat membuka halaman FragmentB
        transaksi.addToBackStack(null)
        transaksi.commit()
    }
}
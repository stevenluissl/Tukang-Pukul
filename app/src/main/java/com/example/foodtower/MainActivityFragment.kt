package com.example.foodtower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodtower.Fragment.FragmentA
import com.example.foodtower.Fragment.FragmentB
import com.example.foodtower.Fragment.InterfaceData

class MainActivityFragment : AppCompatActivity(), InterfaceData {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val fragmentA = FragmentA()
        supportFragmentManager
            .beginTransaction().replace(R.id.FragmentContainer, fragmentA).commit()
    }

    override fun KirimData(editText: String) {
        val bundle = Bundle()
        bundle.putString("Pesan", editText)

        val transaksi = this.supportFragmentManager.beginTransaction()

        val fragmentB = FragmentB()
        fragmentB.arguments = bundle
        transaksi.replace(R.id.FragmentContainer, fragmentB)
        transaksi.commit()
    }
}
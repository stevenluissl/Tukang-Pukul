package com.example.foodtower

//menggunakan metode Bundle dengan interface yang berisi method yang dapat diimplementasikan ke MainActivityFragment
// dan dapat digunakan pada kedua FragmentA dan FragmentB

//membuat function dengan parameter editText bertipe data String
interface InterfaceData {
    fun KirimData(editText: String)
}
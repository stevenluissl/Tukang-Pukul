package com.example.foodtower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.subscribepage1.view.*

class RecycleView (private val contact : List<Subs>) : RecyclerView.Adapter<Holder>() {

    //mengimplementasi 3 function
    // untuk view holder untuk menampilkan view yang akan digunakan dan meng-ingflate widget recycler view
    override fun onCreateViewHolder (parent : ViewGroup, viewType : Int): Holder {
        return Holder (
            LayoutInflater.from (parent. context)
                .inflate(R.layout. subscribepage1, parent, false)
        )
    }

    // untuk menghubungkan data kontak dengan layout
    override fun onBindViewHolder(holder : Holder, position : Int ) {
        holder.bindContact(contact[position])
    }

    // menampilkan ukuran jumlah data pada recycler view
    override fun getItemCount (): Int = contact.size

}

// class holder untuk menghubungkan tampilan dari linear layout dengan data
class  Holder (view : View) : RecyclerView.ViewHolder(view) {
    private val contactName = view.LinearNama
    private val contactNumber = view.LinearNo

    fun bindContact(tmp: Subs) {
        contactName.text = "${contactName.text} : ${tmp.nama}"
        contactNumber.text = "${contactNumber.text} : ${tmp.noHp}"
    }
}
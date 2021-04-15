package com.example.foodtower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.subscribepage1.view.*

class RecycleView (private val contact : List<Subs>) : RecyclerView.Adapter<myHolder>() {
    override fun onCreateViewHolder (parent : ViewGroup, viewType : Int): myHolder {
        return myHolder (
            LayoutInflater.from (parent. context)
                .inflate(R.layout. activity_subscribepage, parent, false)
        )
    }

    override fun getItemCount (): Int = contact.size

    override fun onBindViewHolder(holder : myHolder, position : Int ) {
        holder.bindContact(contact[position])
    }

}

class  myHolder (view : View) : RecyclerView.ViewHolder(view) {
    private val contactName = view.LinearNama
    private val contactNumber = view.LinearNo

    fun bindContact(tmp: Subs) {
        contactName.text = "${contactName.text} : $tmp.nama}"
        contactNumber.text = "${contactNumber.text} : $tmp. nomorHp"
    }
}
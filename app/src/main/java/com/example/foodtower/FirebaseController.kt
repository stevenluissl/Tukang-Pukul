package com.example.foodtower

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseController (context: Context) {
    private var database = Firebase.database
    private val reference = database.getReference("USER")
    private val myContext = context

    fun saveUser(users: DataClassFirebase) {
        var usersID = reference.push().key.toString()

        reference.child(usersID).setValue(users).apply {
            addOnCompleteListener {
                Toast.makeText(myContext,"Data Saved.",Toast.LENGTH_SHORT)
            }
            addOnCanceledListener {  }
            addOnFailureListener {
                Toast.makeText(myContext,"Save Data Failed.",Toast.LENGTH_SHORT)
            }
            addOnSuccessListener {  }
        }
    }
    private fun readUsername() : MutableMap<String,String> {
        var hasil = mutableMapOf<String,String>()
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot!!.exists()) {
                    for (data in snapshot.children) {
                        val user = data.getValue(DataClassFirebase::class.java)
                        user.let {
                            hasil.put(data.key.toString(), it!!.nama)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return hasil
    }
}
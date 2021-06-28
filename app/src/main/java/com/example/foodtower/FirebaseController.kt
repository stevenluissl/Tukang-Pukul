package com.example.foodtower

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseController (context: Context) {
    //implementasi database firebase
    private var database = Firebase.database
    //mendapatkan data referensi dari path USERS pada database firebase
    private val reference = database.getReference("USERS")
    //implementasi context
    private val myContext = context

    //function untuk menympan data pada database
    fun saveUser(users: DataClassFirebase) {
        //deklarasi userID untuk mengirimkan data pada database USERS
        var usersID = reference.push().key.toString()

        //untuk menambahkan cabang child pada database USERS
        reference.child(usersID).setValue(users).apply {
            //jika berhasil maka akan menampilkan toast Data Saved
            addOnCompleteListener {
                Toast.makeText(myContext,"Data Saved.",Toast.LENGTH_SHORT)
            }
            addOnCanceledListener {  }
            //jika gagal amaka akan menampilkan toast Save Data Failed
            addOnFailureListener {
                Toast.makeText(myContext,"Save Data Failed.",Toast.LENGTH_SHORT)
            }
            addOnSuccessListener {  }
        }
    }

    //function untuk men-detect data nama pada database
    private fun readUsername() : MutableMap<String,String> {
        //implementasi hasil yang merupakan muttable map
        var hasil = mutableMapOf<String,String>()
        //mencari data pada database
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //jika database terdapat data
                if(snapshot!!.exists()) {
                    hasil.clear()
                    for (data in snapshot.children) {
                        val user = data.getValue(DataClassFirebase::class.java)
                        user?.let {
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

    fun deleteUser(srcUsername : String) {
        val key = readUsername().filterValues { it == srcUsername }.keys
        reference.child(key.first())
        Toast.makeText(myContext,"Data Deleted.",Toast.LENGTH_SHORT)
    }

    fun dataExist(srcName: String) : Boolean {
        if(readUsername().containsValue(srcName))
            return true
        return false
    }
}
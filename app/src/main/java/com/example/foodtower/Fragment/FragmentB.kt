package com.example.foodtower.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.foodtower.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    //supaya data yang dikirm dari FragmentA dapat ditampung
    //inisialisasi pesan awal dengan tipe data string dengan check null
    //jika null maka default string kosong
    var pesann : String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        //inisialisasi val view sehingga dapat menggunakan property dari fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        //mengecek argument dari bundle apakah null, jika tidak ambil dara dengan key "pesan"
        //menggunakan Bundle dengan arguments dan dengan key Pesan
        pesann = arguments?.getString("Pesan")

        //menginisialisasikan component
        val pesan = view.findViewById<TextView>(R.id.Hasil)

        //trampilan pesan
        pesan.text = pesann

        //return view supaya untuk menampilkan pesan yang akan dilihat oleh pengguna
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentB.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
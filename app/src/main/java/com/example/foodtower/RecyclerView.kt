package com.example.foodtower

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.subscribepage1.*

class RecyclerView : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    //membuat variabel untuk menunjukkan nama kontak
    var DisplayName = ContactsContract.Contacts.DISPLAY_NAME
    //membuat variabel untuk menunjukkan nomor telepon
    var noTelp = ContactsContract.CommonDataKinds.Phone.NUMBER

    var listContact : MutableList<Subs> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        LoaderManager.getInstance(this).initLoader(1, null, this)
    }

    // mereturn cursor loader dari uri dalam bentuk array dan menampilkan datanya secara ascending
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        var contactUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        var data = arrayOf(DisplayName,noTelp)
        return CursorLoader (this, contactUri, data, null,
            null, "$DisplayName ASC")
    }

    // membaca data dari kontak
    override fun onLoadFinished(loader: Loader<Cursor>, tess: Cursor?) {
        listContact.clear()
        if(tess != null) {
            tess.moveToFirst()
            while (!tess.isAfterLast) {
                listContact.add(
                    Subs(
                        tess.getString(tess.getColumnIndex(DisplayName)),
                        tess.getString(tess.getColumnIndex(noTelp))
                    )
                )
                tess.moveToNext()
            }
        }

        // menempatkan dan menampilkan seluruh data pada recycler view
        var contactAdapter = RecycleView(listContact)
        kolom.apply {
            layoutManager = LinearLayoutManager (this@RecyclerView)
            adapter = contactAdapter
        }
    }

    // jika data berbeda maka Loader Reset akan dijalankan
    override fun onLoaderReset(loader: Loader<Cursor>) {
        kolom.adapter?.notifyDataSetChanged()
    }
}
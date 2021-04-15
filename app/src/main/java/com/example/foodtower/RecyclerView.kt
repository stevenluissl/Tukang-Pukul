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

class RecyclerView : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    var DisplayName = ContactsContract.Contacts.DISPLAY_NAME
    var noTelp = ContactsContract.CommonDataKinds.Phone.NUMBER
    var stats = ContactsContract.Contacts.EXTRA_ADDRESS_BOOK_INDEX

    var listContact : MutableList<Subs> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        LoaderManager.getInstance(this).initLoader(1, null, this)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        var contactUri = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI
        var data = arrayOf(DisplayName,noTelp,stats)
        return CursorLoader (this, contactUri, data, null,
            null, "$DisplayName DESC")
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        listContact.clear()
        if(data != null) {
            data.moveToFirst()
            while (!data.isAfterLast) {
                listContact.add(
                    Subs(
                        data.getString(data.getColumnIndex(DisplayName)),
                        data.getString(data.getColumnIndex(noTelp))
                    )
                )
                data.moveToNext()
            }
            var contactAdapter = RecycleView(listContact)
            kolom.apply {
                layoutManager = LinearLayoutManager (this@RecyclerView)
                adapter = contactAdapter
            }
        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        kolom.adapter?.notifyDataSetChanged()
    }
}
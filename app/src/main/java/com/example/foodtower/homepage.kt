package com.example.foodtower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_homepage.*

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        //image slider
        val sampleImages = intArrayOf(
            R.drawable.reccomendation,
            R.drawable.gmbr1,
            R.drawable.gmbr2,
            R.drawable.gmbr3
        )

        val imagesListener = ImageListener { position: Int, imageView: ImageView? ->
            if (imageView != null) {
                imageView.setImageResource(sampleImages[position])
            }
        }
//image slider
            caroselView.pageCount = sampleImages.size
            caroselView.setImageListener(imagesListener)
//image slider

        //search view
        val search = findViewById<SearchView>(R.id.searchView)
        val listView = findViewById<ListView>(R.id.listView)

        val names= arrayOf("")

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,names
        )

        listView.adapter = adapter

        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                search.clearFocus()
                if(names.contains(p0))
                {
                    adapter.filter.filter(p0)
                }else{
                    Toast.makeText(applicationContext,"item not found",Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

        })
//search view
        chefpage.setOnClickListener {
            val intent = Intent(this,chefmenu::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this,chefmenu::class.java)
            startActivity(intent)
        }
    }
}
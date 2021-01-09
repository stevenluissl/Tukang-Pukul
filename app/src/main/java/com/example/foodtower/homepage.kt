package com.example.foodtower

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
    }
}
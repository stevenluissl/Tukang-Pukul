package com.example.foodtower

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class addingfood {
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(adding_food::class.java)

    @Test
    fun camera() {
        onView(withId(R.id.camera)).perform(ViewActions.click())

    }

    //pengujian untuk memastikan data intent telah benar sesuai dengan data
    @Test
    fun intent() {
        //melakukan perform klik pada tombol yang menjalankan pengiriman data intent
        onView(withId(R.id.button4)).perform (click())
        //melakukan pengecekkan apakah data yang ditampilkan sudah benar
        onView(withId(R.id.textView)).check(matches(withText("nama = Adi dengan Umur 32")))
    }
}

class subs {
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(subscribepage::class.java)

    @Test
    fun textbox() {
        onView(withId(R.id.editTextNama)).perform(ViewActions.typeText("Budi"))
        onView(withId(R.id.clear)).perform(ViewActions.click())
    }

}
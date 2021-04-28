package com.example.foodtower

import android.graphics.Bitmap
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.URL

@RunWith(AndroidJUnit4::class)
class addingfood {
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(adding_food::class.java)

    @Test
    fun textbox() {
        onView(withId(R.id.editTextTextPostalAddress)).perform(ViewActions.typeText("lorem ipsum"))
        onView(withId(R.id.button3)).perform(ViewActions.click())
    }
    fun camera() {
        onView(withId(R.id.camera)).perform(ViewActions.click())
        var gambar : org.hamcrest.Matcher<Bitmap>? =
            allOf(
                hasData(URL("https://www.masakapahariini.com/wp-content/uploads/2019/01/nasi-goreng-jawa-620x440.jpg"))4
            )
    }

    @Test
    fun intent() {
        onView(withId(R.id.button4)).perform (ViewActions.click())
    }
}

class Test2 {

}
package com.example.foodtower

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.mashape.unirest.http.Unirest
import kotlinx.android.synthetic.main.activity_chef_page.*
import kotlinx.android.synthetic.main.activity_food_menu1.*
import kotlinx.android.synthetic.main.activity_homepage.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import kotlin.random.Random


class chef_page : AppCompatActivity() {
    var JobSchedulerID = 37
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef_page)

        /*
        var serviceComponent = ComponentName(this,FoodRec::class.java)
        var myJobInfo = JobInfo.Builder(JobSchedulerID, serviceComponent)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setRequiresDeviceIdle(false)
            .setRequiresCharging(false)
            .setPeriodic(3*60*1000)
        var JobFood = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        JobFood.schedule(myJobInfo.build())
        Toast.makeText(this,"Job Service Berjalan", Toast.LENGTH_SHORT).show()
        doAsync {
            var response =
                //menggunakan Unirest untuk mendapatkan API dari API Nutrisi
                Unirest.get("https://nutritionix-api.p.rapidapi.com/v1_1/search/kfc?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat")
                    .header("x-rapidapi-key", "af7381486dmsh0c1e11bcfd96e69p105074jsn87cb03d405c2")
                    .header("x-rapidapi-host", "nutritionix-api.p.rapidapi.com")
                    .asString()

            //membuat variabel baru untuk mengecek seluruh body dari API
            var all = response.body

            //membuat variabel baru untuk memanggil Total Hits dari JSON
            var allres = JSONObject(all).getString("total_hits")

            //menampilkan String dari total hits
            activityUiThread {
                textView4.text = allres.toString()
            }

        }*/

        buttonchef.setOnClickListener {
            val intent = Intent(this, client_list::class.java)
            startActivity(intent)
        }

        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val navbar = Intent(this@chef_page,navigation_bar::class.java)
            startActivity(navbar)
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@chef_page,homepage::class.java)
            startActivity(homepage)
        }
        val addmenu = findViewById<ImageButton>(R.id.add_menu)
        addmenu?.setOnClickListener {
            val addfood = Intent(this@chef_page,adding_food::class.java)
            startActivity(addfood)
        }

        smsbutton.setOnClickListener {
            var uriPhone = Uri.parse("smsto: 123456789")
            var intentSMS: Intent = Intent(Intent.ACTION_SENDTO,uriPhone)
            intentSMS.putExtra("sms_body", "")
            startActivity(intentSMS)
        }

        foodrec.setOnClickListener {
            startJob()
        }

        var db = Room.databaseBuilder(
            this, DBUserSubs::class.java, "myUserDataSubs.db"
        ).build()
        savedata.setOnClickListener {
            var hasil = ""
            doAsync {
                var userSubsTMP = userSubs(Random.nextInt())
                userSubsTMP.nama = editTextTextPersonName5.text.toString()
                userSubsTMP.NoHP = editTextTextPersonName6.text.toString()
                userSubsTMP.lokasi = editTextTextPersonName7.text.toString()
                userSubsTMP.bank = editTextTextPersonName8.text.toString()
                userSubsTMP.harga = editTextTextPersonName9.text.toString()
                db.userDAO().InsertDataSubs(userSubsTMP)
                for(allData in db.userDAO().getAllDataSubs()){
                    hasil+= "${allData}"
                }
                uiThread {
                    Log.w("Hasil DB", hasil)
                }
            }
        }

        /*updatedata.setOnClickListener {
            var hasil = ""
            doAsync {
                var userSubsTMP = userSubs(Random.nextInt())
                userSubsTMP.nama = editTextTextPersonName5.text.toString()
                userSubsTMP.NoHP = editTextTextPersonName6.text.toString()
                userSubsTMP.lokasi = editTextTextPersonName7.text.toString()
                userSubsTMP.bank = editTextTextPersonName8.text.toString()
                userSubsTMP.harga = editTextTextPersonName9.text.toString()
                db.userDAO().UpdateDataSubs()
                for(allData in db.userDAO().getAllDataSubs()){
                    hasil+= "$(allData)"
                }
                uiThread {
                    Log.w("Hasil DB", hasil)
                }
            }
        }*/

        deletedata.setOnClickListener {
            doAsync {
                db.userDAO().DeleteDataSubs(editTextTextPersonName5.text.toString())
            }
        }
    }

    private fun startJob() {
        doAsync {
            var response =
                //menggunakan Unirest untuk mendapatkan API dari API Nutrisi
                Unirest.get("https://nutritionix-api.p.rapidapi.com/v1_1/search/kfc?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat")
                    .header("x-rapidapi-key", "af7381486dmsh0c1e11bcfd96e69p105074jsn87cb03d405c2")
                    .header("x-rapidapi-host", "nutritionix-api.p.rapidapi.com")
                    .asString()

            //membuat variabel baru untuk mengecek seluruh body dari API
            var all = response.body

            //membuat variabel baru untuk memanggil Total Hits dari JSON
            var allres = JSONObject(all).getString("total_hits")

            //menampilkan String dari total hits
            textView4.text = allres.toString()

        }
    }
}
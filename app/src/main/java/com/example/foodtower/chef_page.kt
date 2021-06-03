package com.example.foodtower

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mashape.unirest.http.Unirest
import kotlinx.android.synthetic.main.activity_chef_page.*
import kotlinx.android.synthetic.main.activity_food_menu1.*
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_subscribepage.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject


class chef_page : AppCompatActivity() {
    var SQLitedb : sqlite_DBhelper? = null
//    var myFirstRun : FirstRun? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef_page)

        SQLitedb = sqlite_DBhelper(this)

        savedata.setOnClickListener {
            var userTmp = sqlite_user()
            userTmp.nama = chefpage_name.text.toString()
            userTmp.no_telp = chefpage_hp.text.toString()
            userTmp.lokasi = chefpage_location.text.toString()
            userTmp.rekening = chefpage_rekening.text.toString()
            userTmp.harga = chefpage_price.text.toString()

            var result = SQLitedb?.addUser(userTmp)
            if (result != 1L) {
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
            }
            updateAdapter()
            chefpage_name.text.clear()
            chefpage_hp.text.clear()
            chefpage_location.text.clear()
            chefpage_rekening.text.clear()
            chefpage_price.text.clear()
        }
        deletedata.setOnClickListener {
            var nama = chefpage_spinner.selectedItem.toString()
            if (nama != null || nama != "") {
                doAsync {
                    SQLitedb?.deleteUser(nama)
                    updateAdapter()
                }
            }
        }
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

/*

        // Membuat database dengan nama myUserDataSubs.db
        var db = Room.databaseBuilder(
            this, DBUserSubs::class.java, "myUserDataSubs.db"
        ).build()

        */
/*doAsync {
            db.userDAO().nukeTable()
        }*//*


        */
/*myFirstRun = FirstRun(this)
        myFirstRun?.firstRun = true
        if(myFirstRun!!.firstRun) {
            var secondIntent = Intent(this, pre_load::class.java)
            startActivity(secondIntent)
        }*//*


        savedata.setOnClickListener {
            doAsync {
                // Mendeklarasikan userSubs dan men-generate angka random untuk id (primary key)
                var userSubsTMP = userSubs(Random.nextInt())
                // Data yang diinput pada edit text akan masuk ke database
                userSubsTMP.nama = chefpage_name.text.toString()
                userSubsTMP.NoHP = chefpage_hp.text.toString()
                userSubsTMP.lokasi = chefpage_location.text.toString()
                userSubsTMP.bank = chefpage_rekening.text.toString()
                userSubsTMP.harga = chefpage_price.text.toString()
                // Memanggil database userSubsDAO dan query InsertDataSubs
                db.userDAO().InsertDataSubs(userSubsTMP)
            }
        }

        deletedata.setOnClickListener {
            doAsync {
                // Memanggil database userSubsDAO dan query DeleteDataSubs
                // untuk menghapus seluruh kolom yang memiliki data nama yang diinput di edit text nama
                db.userDAO().nukeTable()
            }
        }



        updatedata.setOnClickListener {
            doAsync {
                // Memanggil database userSubsDAO dan query UpdateDataSubs
                // untuk mengubah seluruh data pada kolom
                // dengan menggunakan data nomor rekening sebagai acuan
                db.userDAO().UpdateDataSubs(chefpage_name.text.toString(), chefpage_hp.text.toString(),
                    chefpage_location.text.toString(), chefpage_price.text.toString(),chefpage_rekening.text.toString())
            }
        }
*/

    }

    fun updateAdapter () {
        doAsync {
            var nameList = SQLitedb?.viewAllName()?.toTypedArray()
            uiThread {
                if (chefpage_spinner != null && nameList?.size != 0) {
                    var arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, nameList!!)
                    chefpage_spinner.adapter = arrayAdapter
                }
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
            chefpage_textView.text = allres.toString()
        }
    }
}
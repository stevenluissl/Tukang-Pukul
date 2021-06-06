package com.example.foodtower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pre_load.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class pre_load : AppCompatActivity() {
    var sqliteDbhelper : sqlite_DBhelper? = null
    //data untuk dimasukkan ke database
    private var chef = listOf(
        sqlite_user(1,"X1","","","",""),
        sqlite_user(2,"X2","","","",""),
        sqlite_user(3,"X3","","","",""),
        sqlite_user(4,"X4","","","",""),
        sqlite_user(5,"X5","","","",""),
        sqlite_user(6,"X6","","","",""),
        sqlite_user(7,"X7","","","",""),
        sqlite_user(8,"X8","","","",""),
        sqlite_user(9,"X9","","","",""),
        sqlite_user(10,"X10","","","",""),
        sqlite_user(11,"X11","","","",""),
        sqlite_user(12,"X12","","","",""),
        sqlite_user(13,"X13","","","",""),
        sqlite_user(14,"X14","","","",""),
        sqlite_user(15,"X15","","","",""),
        sqlite_user(16,"X16","","","",""),
        sqlite_user(17,"X17","","","",""),
        sqlite_user(18,"X18","","","",""),
        sqlite_user(19,"X19","","","",""),
        sqlite_user(20,"X20","","","",""),
        sqlite_user(21,"X21","","","",""),
        sqlite_user(22,"X22","","","",""),
        sqlite_user(23,"X23","","","",""),
        sqlite_user(24,"X24","","","",""),
        sqlite_user(25,"X25","","","",""),
        sqlite_user(26,"X26","","","",""),
        sqlite_user(27,"X27","","","",""),
        sqlite_user(28,"X28","","","",""),
        sqlite_user(29,"X29","","","",""),
        sqlite_user(30,"X30","","","",""),
        sqlite_user(31,"X31","","","",""),
        sqlite_user(32,"X32","","","",""),
        sqlite_user(33,"X33","","","",""),
        sqlite_user(34,"X34","","","",""),
        sqlite_user(35,"X35","","","",""),
        sqlite_user(36,"X36","","","",""),
        sqlite_user(37,"X37","","","",""),
        sqlite_user(38,"X38","","","",""),
        sqlite_user(39,"X39","","","",""),
        sqlite_user(40,"X40","","","",""),
        sqlite_user(41,"X41","","","",""),
        sqlite_user(42,"X42","","","",""),
        sqlite_user(43,"X43","","","",""),
        sqlite_user(44,"X44","","","",""),
        sqlite_user(45,"X45","","","",""),
        sqlite_user(46,"X46","","","",""),
        sqlite_user(47,"X47","","","",""),
        sqlite_user(48,"X48","","","",""),
        sqlite_user(49,"X49","","","",""),
        sqlite_user(50,"X50","","","","")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_load)

        preload_yes.setOnClickListener {
            executeLoadDataTransaction()
        }
        preload_no.setOnClickListener{
            finishThisActivity()
        }
    }

    private fun executeLoadDataTransaction() {
        preload_no.isEnabled = false
        preload_yes.isEnabled = false
        progressBar.progress = 0
        progressBar.max = chef.size
        sqliteDbhelper = sqlite_DBhelper(this)
        doAsync {
            sqliteDbhelper?.begintrans()
            for(userData in chef) {
                sqliteDbhelper?.addusertrans(userData)
                uiThread {
                    progressBar.progress += 1
                }
            }
            sqliteDbhelper?.successtrans()
            sqliteDbhelper?.endusertrans()
            uiThread {
                finishThisActivity()
            }
        }
    }

    private fun finishThisActivity() {
        var myFirstRun = FirstRun(this)
        //ketika menekan tombol no pada preload maka first run akan bernilai false
        //dan aktivitas tidak akan dijalankan lagi
        myFirstRun.firstRun = false
        this.finish()
    }

    /*private fun executeLoadData() {
        preload_no.isEnabled = false
        preload_yes.isEnabled = false

        progressBar.progress = 0
        progressBar.max = chef.size

        sqliteDbhelper = sqlite_DBhelper(this)
        doAsync {
            for(userData in chef) {
                sqliteDbhelper?.addUser(userData)
                uiThread {
                    progressBar.progress += 1
                }
            }
            uiThread {
                finishThisActivity()
            }
        }
    }*/
}
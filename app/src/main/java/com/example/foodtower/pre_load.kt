package com.example.foodtower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pre_load.*

class pre_load : AppCompatActivity() {
    var myUserSubs : sqlite_DBhelper? = null
    private var chef = listOf(
        userSubs(1,"X1","","","",""),
        userSubs(2,"X2","","","",""),
        userSubs(3,"X3","","","",""),
        userSubs(4,"X4","","","",""),
        userSubs(5,"X5","","","",""),
        userSubs(6,"X6","","","",""),
        userSubs(7,"X7","","","",""),
        userSubs(8,"X8","","","",""),
        userSubs(9,"X9","","","",""),
        userSubs(10,"X10","","","",""),
        userSubs(11,"X11","","","",""),
        userSubs(12,"X12","","","",""),
        userSubs(13,"X13","","","",""),
        userSubs(14,"X14","","","",""),
        userSubs(15,"X15","","","",""),
        userSubs(16,"X16","","","",""),
        userSubs(17,"X17","","","",""),
        userSubs(18,"X18","","","",""),
        userSubs(19,"X19","","","",""),
        userSubs(20,"X20","","","",""),
        userSubs(21,"X21","","","",""),
        userSubs(22,"X22","","","",""),
        userSubs(23,"X23","","","",""),
        userSubs(24,"X24","","","",""),
        userSubs(25,"X25","","","",""),
        userSubs(26,"X26","","","",""),
        userSubs(27,"X27","","","",""),
        userSubs(28,"X28","","","",""),
        userSubs(29,"X29","","","",""),
        userSubs(30,"X30","","","",""),
        userSubs(31,"X31","","","",""),
        userSubs(32,"X32","","","",""),
        userSubs(33,"X33","","","",""),
        userSubs(34,"X34","","","",""),
        userSubs(35,"X35","","","",""),
        userSubs(36,"X36","","","",""),
        userSubs(37,"X37","","","",""),
        userSubs(38,"X38","","","",""),
        userSubs(39,"X39","","","",""),
        userSubs(40,"X40","","","",""),
        userSubs(41,"X41","","","",""),
        userSubs(42,"X42","","","",""),
        userSubs(43,"X43","","","",""),
        userSubs(44,"X44","","","",""),
        userSubs(45,"X45","","","",""),
        userSubs(46,"X46","","","",""),
        userSubs(47,"X47","","","",""),
        userSubs(48,"X48","","","",""),
        userSubs(49,"X49","","","",""),
        userSubs(50,"X50","","","","")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_load)

        preload_yes.setOnClickListener {
            executeLoadData()
        }
        preload_no.setOnClickListener{
            finishThisActivity()
        }
    }

    private fun finishThisActivity() {
        var myFirstRun = FirstRun(this)
        myFirstRun.firstRun = false
        this.finish()
    }

    private fun executeLoadData() {
        preload_no.isEnabled = false
        preload_yes.isEnabled = false

        progressBar.progress = 0
        progressBar.max = chef.size


    }
}
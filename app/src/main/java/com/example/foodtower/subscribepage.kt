 package com.example.foodtower

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_adding_food.*
import kotlinx.android.synthetic.main.activity_chef_page.*
import kotlinx.android.synthetic.main.activity_subscribepage.*

private var sound : SoundPool? = null
private var idsound = 0
private var myIntentService : Intent? = null

class subscribepage : AppCompatActivity(),interfaceSubs, View.OnClickListener {

    lateinit var controller: FirebaseController

    private val subsPrefFileName = "MySubsPref"
    var DisplayName = ContactsContract.Contacts.DISPLAY_NAME
    var noTelp = ContactsContract.CommonDataKinds.Phone.NUMBER
    var stats = ContactsContract.Contacts.EXTRA_ADDRESS_BOOK_INDEX

    var listContact: MutableList<Subs> = ArrayList()

    //notification manager untuk memunculkan atau menghilangkan notification
    lateinit var notificationManager: NotificationManager

    //notificationchannel kita bisa mengdisable atau able kan notifikasi di pengaturan
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelID = "com.example.vicky.notificationexample"

    //notifikasi description akan menampilkan kepada pengguna
    private val description = "Test Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscribepage)

        controller = FirebaseController(this)

        var submit = findViewById<Button>(R.id.btnSubmit)
        var delete = findViewById<Button>(R.id.btnDeleteData)
        submit.setOnClickListener {
            saveData()
        }
        delete.setOnClickListener {
            deleteUser()
        }

        play_music.setOnClickListener{
            //untuk membuat pada saat kita menekan play maka yang keluar akan stop
            if (play_music.text.toString().toUpperCase().equals("PLAY")){
                play_music.text = "STOP"
                //menjalankan perintah myIntentService pada playmusic.kt
                myIntentService?.setAction(ACTION_PLAY)
                startService(myIntentService)
            }
            else{
                //untuk membuat kata stop menjadi play
                play_music.text = "PLAY"
                myIntentService?.setAction(ACTION_STOP)
                startService(myIntentService)
            }
        }

        /* LoaderManager.getInstance(this).initLoader(1, null, this)*/

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //MVP

        var harga = "0"
        var dataharga = presenterSubs(this)
        clear.setOnClickListener {

            //jika idsound tidak sama dengan 0 maka akan mengembalikan data yang telah berhasil di load
            if(idsound != 0) {
                //memutarkan lagu dan tidak melakukan loop
                sound?.play(idsound,.99f,.99f,1,0,.99f)
            }

           var nama = editTextNama.text.toString()
            //mengecek apakah textbox tersebut kosong, bila kosong maka akan menampilkan error "Nama Tidak Boleh Kosong"
            if(nama.isEmpty()) {
                editTextNama.setError("Nama Tidak Boleh Kosong")
            }
            //jika ada text maka
            //menggunakan fungsi dari Presenter untuk mengirimkan data Nama dan Harga
            else {
               dataharga.hitungharga(nama,harga)
            }
        }

        /*btnDeleteData.setOnClickListener {

            editTextNama.clearComposingText()
            val intent = Intent(this, LauncherActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            //saat melakukan aksi pada notifikasi, akan langsung difoward ke halaman menu chef
            val intent2 = Intent(this, chefmenu::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            //mengatur backstack
            val mPendingIntent = TaskStackBuilder.create(this)
                .addNextIntentWithParentStack(intent2)
                .getPendingIntent(37, PendingIntent.FLAG_UPDATE_CURRENT)

            //pending intent berfungsi untuk meng-execute notification action saat berada di app lain
            //val ActionPendingIntent : PendingIntent = PendingIntent.getActivity(this, 0, intent2, 0)

            //coding ini akan dijalankan jika versi android yang dijalankan adalah versi Oreo
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(channelID, description, NotificationManager.IMPORTANCE_HIGH)
                //untuk memunculkan cahaya
                notificationChannel.enableLights(true)
                //untuk memunculkan warna pada cahaya
                notificationChannel.lightColor = Color.GREEN
                //membuat getaran jika ada notifikasi yang masuk
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)
                //setsShowBadge berfungsi untuk memunculkan Dot Notification
                //jika true maka Dot Notification tidak akan ditampilkan
                //jika false maka Dot Notification akan ditampilkan pada icon aplikasi
                notificationChannel.setShowBadge(false)

                builder = Notification.Builder(this, channelID)
                    //membuat title notifikasi
                    .setContentTitle("FoodTower")
                    //membuat text notifikasi
                    .setContentText("Test Notification")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_launcher_round
                        )
                    )
                    .setContentIntent(pendingIntent)
                    //action pada notification yang akan meneruskan ke halaman menu
                    .addAction(R.drawable.gmbr1, "View Menu", mPendingIntent)
            } else {
                builder = Notification.Builder(this)
                    .setContentTitle("FoodTower")
                    .setContentText("Test Notification")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_launcher_round
                        )
                    )
                    .setContentIntent(pendingIntent)
                    //action pada notification yang akan meneruskan ke halaman menu
                    .addAction(R.drawable.gmbr1, "View Menu", mPendingIntent)
            }
            //notification akan di panggil dan juga harus memiliki id yang unik juga
            notificationManager.notify(1234, builder.build())

        }*/

        val backsatu = findViewById<ImageButton>(R.id.backsatu)
        backsatu?.setOnClickListener {
            val chefmenu = Intent(this@subscribepage, chefmenu::class.java)
            startActivity(chefmenu)
            if(idsound != 0) {
                sound?.play(idsound,.99f,.99f,1,0,.99f)
            }
        }
        val hometop = findViewById<ImageButton>(R.id.hometop)
        hometop?.setOnClickListener {
            val homepage = Intent(this@subscribepage, homepage::class.java)
            startActivity(homepage)
            if(idsound != 0) {
                sound?.play(idsound,.99f,.99f,1,0,.99f)
            }

        }

        /*val tesbutton = findViewById<Button>(R.id.tesbutton)
        tesbutton?.setOnClickListener {
            val RecyclerView = Intent(this@subscribepage, RecyclerView::class.java)
            startActivity(RecyclerView)
            if(idsound != 0) {
                sound?.play(idsound,.99f,.99f,1,0,.99f)
            }
        }*/

        subs.setOnClickListener {
            //akses dan simpan file
            var subspref = SubsSharedPref(this, subsPrefFileName)
            //menyimpan data yang diinput ke dalam file
            subspref.subsname = editTextNama.text.toString()
            subspref.subsphonenumber = editTextPhone.text.toString()
            subspref.subsaddress = editTextAlamat.text.toString()
            subspref.subscity = editTextCity.text.toString()
            subspref.subsdistrict = editTextKecamatan.text.toString()
            Toast.makeText(this, "Subs Berhasil",Toast.LENGTH_SHORT).show()
            editTextNama.text.clear()
            editTextPhone.text.clear()
            editTextAlamat.text.clear()
            editTextCity.text.clear()
            editTextKecamatan.text.clear()
        }

        showData.setOnClickListener {
            //akses dan simpan file
            var subspref = SubsSharedPref(this, subsPrefFileName)
            //menampilkan data dari file
            editTextNama.setText(subspref.subsname)
            editTextPhone.setText(subspref.subsphonenumber)
            editTextAlamat.setText(subspref.subsaddress)
            editTextCity.setText(subspref.subscity)
            editTextKecamatan.setText(subspref.subsdistrict)
        }
    }

    private fun deleteUser() {
        var userDeleted = findViewById<EditText>(R.id.editTextDeleteData)
        if (controller.dataExist(userDeleted.text.toString())) {
            AlertDialog.Builder(this).apply {
                setTitle("Data Found.")
                setMessage("Delete data?")
                    .setPositiveButton("Yes",DialogInterface.OnClickListener {
                        dialogInterface, i ->  controller.deleteUser(userDeleted.text.toString())
                    })
                    .setNegativeButton("No",DialogInterface.OnClickListener{
                        dialogInterface, i -> userDeleted.text.clear()
                    })
            }.show()
        }
        else {
            AlertDialog.Builder(this).apply {
                setTitle("Data Not Found.")
                setMessage("Data can't be found.")
                    .setPositiveButton("OK",DialogInterface.OnClickListener{
                            dialogInterface, i -> userDeleted.text.clear()
                    })
            }.show()
        }
    }

    private fun saveData() {
        controller.saveUser(DataClassFirebase(
            editTextNama.text.toString(),
            editTextPhone.text.toString(),
            editTextAlamat.text.toString(),
            editTextCity.text.toString(),
            editTextKecamatan.text.toString() )
        )
        editTextNama.text.clear()
        editTextPhone.text.clear()
        editTextAlamat.text.clear()
        editTextCity.text.clear()
        editTextKecamatan.text.clear()
    }

    //menampilkan Harga ke dalam view
    override fun tampilharga(String: dataSubs) {
        price.text = String.nominal
    }

    //membuat function untuk mulai membaca data
    override fun onStart() {
        super.onStart()
        //memeriksa apakah build in device terinstall versi android lollipop atau ke atas
        //maka akan menjalankan function NewSoundPool
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool()
        }
        //jika versi android di bawah lollipop maka function OldSoundPool akan dijalankan
        else {
            createOldSoundPool()
        }
        //melakukan load data
        sound?.setOnLoadCompleteListener {soundPool, id, status ->
            if(status != 0) {
                //jika data gagal di-load maka akan muncul pop up "Load Gagal"
                Toast.makeText(this, "Load Gagal", Toast.LENGTH_SHORT).show()
            }
            //jika data berhasil di-load maka akan muncul pop up "Silahkan Mengisi Data!"
            else {
                Toast.makeText(this, "Silahkan Mengisi Data!", Toast.LENGTH_SHORT).show()
            }
        }
        //melakukan load sebuah file dari folder raw dan membuat priority terpenting
        idsound = sound?.load(this, R.raw.waterdrops, 1) ?: 0
        if (myIntentService==null){
            myIntentService = Intent(this,playmusic::class.java)
            myIntentService?.setAction(ACTION_CREATE)
            startService(myIntentService)
        }
    }

    //melakukan file streaming dengan AudioManager.STREAM_MUSIC
    private fun createOldSoundPool() {
        sound = SoundPool(15, AudioManager.STREAM_MUSIC, 0)
    }
    //melakukan file streaming dengan SoundPool.Buider
    private fun createNewSoundPool() {
        sound = SoundPool.Builder()
            .setMaxStreams(15)
            .build()
    }
    //merelease data yang telah di load
    override fun onStop() {
        super.onStop()
        sound?.release()
        sound = null

    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(myIntentService)
    }

    override fun onClick(p0: View?) {

    }
}



 /*override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
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
             layoutManager = ConstraintLayoutStates (this@subscribepage)
             adapter = contactAdapter
         }
     }
 }

 override fun onLoaderReset(loader: Loader<Cursor>) {
     kolom.adapter?.notifyDataSetChanged()
 }*/


//    fun getAlertDialog(view: View) {
//        var reqinformation = AlertDialog.Builder(this)
//            .setTitle("Alert")
//            .setMessage("Apakah anda ingin Request Information?")
//            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
//                Toast.makeText(this,"Request Berhasil", Toast.LENGTH_SHORT).show()
//            })
//            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
//                Toast.makeText(this,"", Toast.LENGTH_SHORT).show()
//            })
//        reqinformation.show()
//    }

package com.example.mysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL


class MainActivity : AppCompatActivity() {





    lateinit var editText_id: EditText
    lateinit var editText_nama: EditText
    lateinit var editText_alamat: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //texview_hasil = findViewById(R.id.textView_hasil)
        editText_id = findViewById(R.id.editText_ID)
        editText_nama = findViewById(R.id.editText_nama)
        editText_alamat =findViewById(R.id.editText_alamat)

        textView_hasil.setText("welcome")
    }

    fun button_read(view: View) {


       GlobalScope.async {
           var id:String = editText_id.text.toString()

           var alamat = "http://192.168.30.104/simple/getId.php?id= $id"
          var  hasil:String  = getJsonFromURL(alamat).toString()
           textView_hasil.setText(hasil)
      }

    }


    fun button_insert(view: View) {

        var nama:String = editText_nama.text.toString()
        var alamat:String =editText_alamat.text.toString()

        GlobalScope.launch {

            URL("http://192.168.30.104/simple/insert.php?nama=$nama&alamat=$alamat").openStream()
        }

    }


    fun button_update(view: View) {

        // isi update untuk tugas
    }
    fun button_delete(view: View) {

        var id:String = editText_id.text.toString()



        GlobalScope.launch {

            URL("http://192.168.30.104/simple/delete.php?id=$id").openStream()
        }

    }


    fun getJsonFromURL(wantedURL: String) : String {
        return URL(wantedURL).readText()
    }

}



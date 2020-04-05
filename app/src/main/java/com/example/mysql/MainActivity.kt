package com.example.mysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import java.net.URL


class MainActivity : AppCompatActivity() {





    lateinit var editText_id: EditText
    lateinit var editText_nama: EditText
    lateinit var editText_alamat: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        editText_id = findViewById(R.id.editText_ID)
        editText_nama = findViewById(R.id.editText_nama)
        editText_alamat =findViewById(R.id.editText_alamat)

        textView_hasil.setText("welcome")
    }

    fun button_read(view: View) {
    }

    fun button_insert(view: View) {
    }

    fun button_update(view: View) {

        // isi update untuk tugas
    }
    fun button_delete(view: View) {



    }




}



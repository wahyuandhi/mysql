package com.example.mysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mysql.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewHasil.setText("welcome")
    }

    fun button_read(view: View) {
        GlobalScope.async {
            var id: String = binding.editTextID.text.toString()

            var alamat = "ip-server/simple/getId.php?id=$id"
            var hasil: String = getJsonFromURL(alamat).toString()
            binding.textViewHasil.setText(hasil)
        }
    }

    fun button_insert(view: View) {
        var nama:String = binding.editTextNama.text.toString()
        var alamat:String = binding.editTextAlamat.text.toString()

        GlobalScope.launch {
            URL("ip-server/simple/insert.php?nama=$nama&alamat=$alamat").openStream()
        }
    }

    fun button_update(view: View) {
        var id: String = binding.editTextID.text.toString()
        var nama: String = binding.editTextNama.text.toString()
        var alamat: String = binding.editTextAlamat.text.toString()

        GlobalScope.launch {
            URL("ip-server/simple/update.php?id=$id&nama=$nama&alamat=$alamat").openStream()
        }
    }

    fun button_delete(view: View) {
        var id:String = binding.editTextID.text.toString()
        GlobalScope.launch {
            URL("ip-server/simple/delete.php?id=$id").openStream()
        }
    }

    fun getJsonFromURL(wantedURL: String) : String {
        return URL(wantedURL).readText()
    }
}
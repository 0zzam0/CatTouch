package com.example.cattouch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.cattouch.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    var name : String = ""
    var address : String = ""
    var password : String = ""
    var country : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)

        fun setupSpinnerHandler(){
            binding.spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            }
    }

    }
}
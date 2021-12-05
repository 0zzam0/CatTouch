package com.example.cattouch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattouch.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //바인딩 초기화
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}
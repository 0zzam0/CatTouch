package com.example.cattouch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattouch.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var count : Int = 0
    var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //바인딩 초기화
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.textView7.text = count.toString()

        binding.imageButton3.setOnClickListener {
            count++
            binding.textView7.text = count.toString()
            binding.imageButton3.isSelected = binding.imageButton3.isSelected != true
            binding.score.text= (score + count).toString()
            binding.country.text = "대한민국"
        }
    }
}
package com.example.cattouch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cattouch.databinding.ActivityMainBinding
import com.example.cattouch.databinding.ActivityMain2Binding
import com.example.cattouch.databinding.ActivityMain3Binding


var count :Int =0
var touch = false


class MainActivity : AppCompatActivity() {
    var isRunning=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //바인딩 초기화 (import 단축키 Alt + Enter)
        //초기화 위해서 build.gradle -> android에 viewBinding true 추가하기
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this, MainActivity2::class.java)
        val intent2 = Intent(this, MainActivity3::class.java)
        //레이아웃 표시
        setContentView(binding.root);

        binding.startBtn.setOnClickListener {
            startActivity(intent)
        }
        binding.imageButton.setOnClickListener{
            startActivity(intent2)
        }


            /*//쓰레드
            class touchThread:Thread() {
                override fun run() {
                    while (isRunning) {
                        systemClock.seep(100)
                    }
                }
            }*/




    }




}




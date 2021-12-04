package com.example.cattouch

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

var count :Int =0
var touch = false

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //버튼 클릭 이벤트
    fun buClick(view: View){
        touch = true
    }

}
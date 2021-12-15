package com.example.cattouch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.cattouch.databinding.ActivityMain3Binding
import com.example.cattouch.MainActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //var data = listOf("South Korea", "Hong Kong", "Thailand", "Japan","United States", "Sweden")
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        val ma = MainActivity()
        val intent = Intent(this, MainActivity2::class.java)
        val intent2 = Intent(this, MainActivity::class.java)
        //레이아웃 표시
        setContentView(binding.root);
        binding.startBtn.setOnClickListener {
            startActivity(intent)
        }

        binding.logoutBtn.setOnClickListener{
            ma.signOut()
            startActivity(intent2)
        }


    }
}
package com.example.cattouch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.cattouch.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    var name : String = ""
    var address : String = ""
    var password : String = ""
    var country : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //var data = listOf("South Korea", "Hong Kong", "Thailand", "Japan","United States", "Sweden")
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        //배열 가져오기
        var sData = resources.getStringArray(R.array.country)
        //어댑터로 연결
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)
        binding.spinnerCountry.adapter = adapter

        //세팅
        binding.spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
                country = binding.spinnerCountry.getSelectedItem().toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        //텍스트
        binding.Address.setText("Address")
        binding.Name.setText("Name")
        binding.Password.setText("Password")


    }
}
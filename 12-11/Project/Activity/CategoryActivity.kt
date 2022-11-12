package com.example.e_greetingsheet.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_greetingsheet.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        var i = intent
        Toast.makeText(applicationContext,""+i.getStringExtra("pos"),Toast.LENGTH_LONG).show()


    }
}
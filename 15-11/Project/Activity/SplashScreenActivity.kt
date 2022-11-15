package com.example.e_greetingsheet.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.e_greetingsheet.LoginActivity
import com.example.e_greetingsheet.R

class SplashScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {

                var i =Intent(this, LoginActivity::class.java)
                startActivity(i)

        },3000)
    }
}
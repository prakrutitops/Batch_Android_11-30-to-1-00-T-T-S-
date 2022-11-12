package com.example.e_greetingsheet.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_greetingsheet.Client.ApiClient
import com.example.e_greetingsheet.Interface.Apiinterface
import com.example.e_greetingsheet.R
import com.example.e_greetingsheet.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginActivity : AppCompatActivity()
{
    lateinit var apiinterface: Apiinterface
    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=getSharedPreferences("User_Session",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("User_Session", false) && !sharedPreferences.getString("mob", "")!!.isEmpty())
        {
            startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {

                if(binding.edtMobile.text.toString().length==0)
                {
                    binding.edtMobile.setError("Please Enter Proper Mobile Number")
                }
                else if(binding.edtPass.text.toString().length==0)
                {
                    binding.edtPass.setError("Please Enter Proper Password")
                }
                else
                {
                    var mobile=binding.edtMobile.text.toString()
                    var pass = binding.edtPass.text.toString()

                    apiinterface =ApiClient.getapiclient().create(Apiinterface::class.java)
                    var logincall: Call<Void> = apiinterface.logindata(mobile,pass)
                    logincall.enqueue(object:Callback<Void>{
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {

                            sharedPreferences.edit().putString("mob",mobile).commit()

                            sharedPreferences.edit().putBoolean("User_Session",true).commit()

                            binding.edtMobile.setText("")
                            binding.edtPass.setText("")

                            startActivity(Intent(applicationContext,DashboardActivity::class.java))

                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {

                            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                        }
                    })

                }

        }
        binding.btnNewUser.setOnClickListener {

            startActivity(Intent(this,RegisterActivity::class.java))

        }




    }

    override fun onBackPressed() {
        finishAffinity()
    }
}
package com.example.e_greetingsheet.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_greetingsheet.Client.ApiClient
import com.example.e_greetingsheet.Interface.Apiinterface
import com.example.e_greetingsheet.R
import com.example.e_greetingsheet.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityRegisterBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnRegister.setOnClickListener {

            var fname =binding.edtFirstName.text.toString()
            var lname =binding.edtLastName.text.toString()
            var email =binding.edtEmail.text.toString()
            var phone =binding.edtPhone.text.toString()
            var pass =binding.edtPassword.text.toString()
            var cpass =binding.edtConfirmPassword.text.toString()

            if(pass.length==0 || cpass.length==0)
            {
                Toast.makeText(applicationContext,"Please Enter Proper Password",Toast.LENGTH_LONG).show()
            }
            if(pass.equals(cpass))
            {
                    if(fname.length==0 )
                    {
                        binding.edtFirstName.setError("Please Enter Proper FirstName")
                    }
                    else if(lname.length==0 )
                    {
                        binding.edtLastName.setError("Please Enter Proper LastName")
                    }
                    else if(email.length==0 )
                    {
                        binding.edtEmail.setError("Please Enter Proper Email")
                    }
                    else if(phone.length!=10 )
                    {
                        binding.edtPhone.setError("Please Enter Proper Phone Number")
                    }
                    else
                    {

                            apiinterface =ApiClient.getapiclient().create(Apiinterface::class.java)
                            var registercall: Call<Void> =  apiinterface.registerdetail(fname,lname,phone,email,pass)
                            registercall.enqueue(object :Callback<Void>{
                                override fun onResponse(call: Call<Void>, response: Response<Void>, )
                                {
                                    startActivity(Intent(applicationContext,LoginActivity::class.java))
                                }

                                override fun onFailure(call: Call<Void>, t: Throwable) {

                                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()


                                }
                            })


                    }




            }
            else
            {
                Toast.makeText(applicationContext,"Password and confirm password are not same",Toast.LENGTH_LONG).show()
            }


        }

        binding.btnAlreadyAccount.setOnClickListener {

            startActivity(Intent(this,LoginActivity::class.java))

        }





    }
}
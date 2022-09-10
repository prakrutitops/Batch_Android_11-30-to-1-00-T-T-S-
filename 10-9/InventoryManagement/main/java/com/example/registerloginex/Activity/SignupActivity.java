package com.example.registerloginex.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.registerloginex.Other.MyUrl;
import com.example.registerloginex.R;
import com.example.registerloginex.databinding.ActivityDashBoardBinding;
import com.example.registerloginex.databinding.ActivitySignupBinding;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity
{

    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fname1=binding.edtFirstName.getText().toString();
                String lname1=binding.edtLastName.getText().toString();
                String email1=binding.edtEmail.getText().toString();
                String mob=binding.edtPhone.getText().toString();
                String pass1=binding.edtPassword.getText().toString();
                String cpass1=binding.edtConfirmPassword.getText().toString();


                StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.REGISTER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        Toast.makeText(SignupActivity.this, "Registration Done", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap map =new HashMap();
                        map.put("firstname",fname1);
                        map.put("lastname",lname1);
                        map.put("mobile",mob);
                        map.put("email",email1);
                        map.put("password",pass1);
                        return map;
                    }
                };

                RequestQueue queue= Volley.newRequestQueue(SignupActivity.this);
                queue.add(stringRequest);



            }
        });


        binding.btnAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(i);

            }
        });
    }
}
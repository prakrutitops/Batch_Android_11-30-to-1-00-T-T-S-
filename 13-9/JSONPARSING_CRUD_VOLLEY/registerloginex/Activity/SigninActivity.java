package com.example.registerloginex.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.registerloginex.databinding.ActivitySigninBinding;

import java.util.HashMap;
import java.util.Map;

public class SigninActivity extends AppCompatActivity {


    private ActivitySigninBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);

        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("mob", "").isEmpty())
        {
            startActivity(new Intent(SigninActivity.this,DashBoardActivity.class));
            finish();
        }
        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String mob = binding.edtPhone.getText().toString();
                String pass=binding.edtPassword.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.LOGIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        if(response.trim().equals("0"))
                        {
                            Toast.makeText(SigninActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SigninActivity.this, "Success", Toast.LENGTH_SHORT).show();

                            sharedPreferences.edit().putString("mob",mob).commit();
                            sharedPreferences.edit().putBoolean("user_session",true).commit();

                            startActivity(new Intent(SigninActivity.this, DashBoardActivity.class));
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(SigninActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap map=new HashMap();
                        map.put("mobile",mob);
                        map.put("password",pass);
                        return map;

                    }
                };

                RequestQueue queue= Volley.newRequestQueue(SigninActivity.this);
                queue.add(stringRequest);

            }
        });

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(i);

            }
        });
    }
}